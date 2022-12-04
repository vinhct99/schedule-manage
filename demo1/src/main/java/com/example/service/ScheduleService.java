package com.example.service;


import com.example.common.CommonException;
import com.example.common.CommonFunctions;
import com.example.common.Constants;
import com.example.common.ErrorEnum;
import com.example.dto.ScheduleDto;
import com.example.dto.StatusResponse;
import com.example.entity.Department;
import com.example.entity.Schedule;
import com.example.repository.DepartmentRepo;
import com.example.repository.ScheduleRepo;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.id.IdentityGenerator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Component
@Service
public class ScheduleService {
    private ScheduleRepo repo;
    private DepartmentRepo repoDepart;

    public ScheduleService(ScheduleRepo _repo, DepartmentRepo _repoDepart){
        repo = _repo;
        repoDepart= _repoDepart;
    }

    public StatusResponse createSchedule(ScheduleDto dto) throws Exception {
        Schedule addSchedule = Schedule.of(dto);
        addSchedule.setIsVisible(Constants.VISI_PB);
        addSchedule.setIsPublic(Constants.STATUS_INACTIVE);
        addSchedule.setIsDeleted(Constants.STATUS_INACTIVE);
        addSchedule.setCreatedDateTime(new Date());
        repo.save(addSchedule);
        return CommonFunctions.generateResponse(ErrorEnum.SUCCESS, addSchedule.toDTO());
    }

    public StatusResponse updateSchedule(Integer id ,ScheduleDto dto) throws Exception {
        Schedule current = repo.findById(id).orElseThrow(() -> new CommonException("not-found-schedule"));
        if (current.getIsPublic() == Constants.STATUS_ACTIVE){
            throw new CommonException("schedule-is-publish");
        }
        if (!dto.getCreatedBy().equals(current.getCreatedBy())){
            throw new CommonException("you-not-create");
        }
        if (current.getIsVisible() == Constants.VISI_CC){
            throw new CommonException("schedule-did-send-approve");
        }
        current.setScheduleDesc(dto.getScheduleDesc());
        repo.save(current);
        return CommonFunctions.generateResponse(ErrorEnum.SUCCESS, current.toDTO());
    }

    public StatusResponse getById(Integer id) throws Exception {
        Schedule current = repo.findById(id).orElseThrow(() -> new CommonException("not-found-schedule"));
        return CommonFunctions.generateResponse(ErrorEnum.SUCCESS, current.toDTO());
    }

    public StatusResponse publish(Integer id) throws Exception {
        Schedule current = repo.findById(id).orElseThrow(() -> new CommonException("not-found-schedule"));
        current.setIsPublic(Constants.STATUS_ACTIVE);
        repo.save(current);
        return CommonFunctions.generateResponse(ErrorEnum.SUCCESS, current.toDTO());
    }

    public StatusResponse acceptVis(Integer id) throws Exception {
        Schedule current = repo.findById(id).orElseThrow(() -> new CommonException("not-found-schedule"));
        current.setIsVisible(Constants.VISI_CC);
        current.setIsPublic(Constants.STATUS_INACTIVE);
        repo.save(current);
        return CommonFunctions.generateResponse(ErrorEnum.SUCCESS, current.toDTO());
    }

    public StatusResponse delete(Integer id) {
        Schedule current = repo.findById(id).orElseThrow(() -> new CommonException("not-found-schedule"));
        current.setIsDeleted(Constants.STATUS_ACTIVE);
        repo.save(current);
        return  CommonFunctions.generateResponse(ErrorEnum.SUCCESS, null);
    }

    public StatusResponse getAllByDepart(Integer departId) {
        List<Schedule> lst = repo.findByIsDeletedAndAndIsVisibleAndDeptId(Constants.STATUS_INACTIVE, Constants.VISI_PB, departId);
        return CommonFunctions.generateResponse(ErrorEnum.SUCCESS, toDTOs(lst));
    }

    public StatusResponse getAllPublishPBByDepart(Integer departId) {
        List<Schedule> lst = repo.findByIsPublicAndIsDeletedAndAndIsVisibleAndDeptId(Constants.STATUS_ACTIVE, Constants.STATUS_INACTIVE, Constants.VISI_PB, departId);
        List<ScheduleDto> result = toDTOs(lst);
        return CommonFunctions.generateResponse(ErrorEnum.SUCCESS, result);
    }

    public StatusResponse getAllNotPublishCC() {
        List<Schedule> lst = repo.findByIsPublicAndIsDeletedAndAndIsVisible(Constants.STATUS_INACTIVE, Constants.STATUS_INACTIVE, Constants.VISI_CC);
        List<ScheduleDto> result = toDTOs(lst);

        return CommonFunctions.generateResponse(ErrorEnum.SUCCESS, result);
    }

    public StatusResponse getAllPublishCC() {
        List<Schedule> lst = repo.findByIsPublicAndIsDeletedAndAndIsVisible(Constants.STATUS_ACTIVE, Constants.STATUS_INACTIVE, Constants.VISI_CC);
        List<ScheduleDto> result = toDTOs(lst);

        return CommonFunctions.generateResponse(ErrorEnum.SUCCESS, result);
    }

    public List<ScheduleDto> toDTOs(List<Schedule> objs) {
        List<ScheduleDto> dtos = new ArrayList<>();
        List<Integer> lstDepartId = objs.stream().map(el -> el.getDeptId()).collect(Collectors.toList());
        List<Department> dataDepart = repoDepart.findByIdIn(lstDepartId);
        Map<Integer, String> mapDepart = new HashMap<>();
        for (Department el: dataDepart) {
            mapDepart.put(el.getId(), el.getDepartmentName());
        }

        objs.forEach(obj -> {
            dtos.add(toDTO(obj));
        });
        if (dataDepart.size() > 0) {
            for (ScheduleDto el : dtos) {
                if (mapDepart.get(el.getDeptId()) != null) {
                    el.setDepartName(mapDepart.get(el.getDeptId()));
                }
            }
        }
        return dtos;
    }

    /* convert list model object to DTO before response */
    public List<ScheduleDto> from(List<Schedule> objs) {
        return objs.stream().map(obj -> obj.toDTO()).collect(Collectors.toList());
    }

    /* convert model object to DTO before response */
    public ScheduleDto toDTO(Schedule obj) {
        return Schedule.toDTO(obj);
    }
}

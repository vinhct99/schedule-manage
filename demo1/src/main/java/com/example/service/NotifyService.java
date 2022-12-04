package com.example.service;

import com.example.common.CommonException;
import com.example.common.CommonFunctions;
import com.example.common.Constants;
import com.example.common.ErrorEnum;
import com.example.dto.NotifyDto;
import com.example.dto.StatusResponse;
import com.example.entity.Notify;

import com.example.repository.NotifyRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@Service
public class NotifyService {

    private UserService userService;
    private NotifyRepo repo;

    public NotifyService(NotifyRepo _repo, UserService _userService){
        repo = _repo;
        userService =_userService;
    }

    public StatusResponse createNotify(NotifyDto dto) throws Exception {

            Notify addNotify = Notify.of(dto);
            addNotify.setIsDeleted(Constants.STATUS_INACTIVE);
            repo.save(addNotify);
            return CommonFunctions.generateResponse(ErrorEnum.SUCCESS, addNotify.toDTO());

    }

    public StatusResponse getById(Integer userId) {
        Notify current = repo.findById(userId).orElseThrow(() -> new CommonException("not-found-schedule"));
        return CommonFunctions.generateResponse(ErrorEnum.SUCCESS, current.toDTO());
    }

    public StatusResponse getAll(){
        List<Notify> lst = repo.findByIsDeleted(Constants.STATUS_INACTIVE);
        List<NotifyDto> result = toDTOs(lst);
        return CommonFunctions.generateResponse(ErrorEnum.NOTIFY_NOT_FOUND, result);
    }

    public StatusResponse getAllByUserId(Integer userId){
        List<Notify> lst = repo.findByIsDeletedAndUserId(Constants.STATUS_INACTIVE, userId);
        return CommonFunctions.generateResponse(ErrorEnum.SUCCESS, toDTOs(lst));
    }

    public StatusResponse update(Integer id, NotifyDto dto){
        Notify current = repo.findById(id).orElseThrow(() -> new CommonException("not-found-notify"));
        if (!dto.getCreatedBy().equals(current.getCreatedBy())){
            throw new CommonException("you-not-create");
        }
        current.setNotifyContent(dto.getNotifyContent());
        repo.save(current);
        return CommonFunctions.generateResponse(ErrorEnum.SUCCESS, current.toDTO());
    }

    public StatusResponse delete(Integer id){
        Notify current = repo.findById(id).orElseThrow(() -> new CommonException("not-found-notify"));
        current.setIsDeleted(Constants.STATUS_ACTIVE);
        repo.save(current);
        return CommonFunctions.generateResponse(ErrorEnum.SUCCESS, null);
    }


    public List<NotifyDto> toDTOs(List<Notify> objs) {
        List<NotifyDto> dtos = new ArrayList<>();
        objs.forEach(obj -> {
            dtos.add(toDTO(obj));
        });
        return dtos;
    }

    /* convert list model object to DTO before response */
    public List<NotifyDto> from(List<Notify> objs) {
        return objs.stream().map(obj -> obj.toDTO()).collect(Collectors.toList());
    }

    /* convert model object to DTO before response */
    public NotifyDto toDTO(Notify obj) {
        return Notify.toDTO(obj);
    }


}

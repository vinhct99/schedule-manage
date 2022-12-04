package com.example.service;

import com.example.common.CommonException;
import com.example.common.CommonFunctions;
import com.example.common.Constants;
import com.example.common.ErrorEnum;
import com.example.dto.DepartmentDto;

import com.example.dto.StatusResponse;
import com.example.entity.Department;

import com.example.repository.DepartmentRepo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@Service
public class DepartmentService {
    private UserService userService;
    private DepartmentRepo repo;
    public DepartmentService(DepartmentRepo _repo, UserService _userService){
        repo = _repo;
        userService =_userService;
    }
    public StatusResponse createDepartment(DepartmentDto dto) throws Exception {
        if (userService.checkRole(dto.getCreatedBy())){
            Department addDepartment = Department.of(dto);
            addDepartment.setIsDeleted(Constants.STATUS_INACTIVE);
            repo.save(addDepartment);
            return CommonFunctions.generateResponse(ErrorEnum.DEPARTMENT_NOT_FOUND, addDepartment.toDTO());
        }
        else {
            throw new CommonException("you-not-role-create");
        }
    }

    public StatusResponse getById(Integer id){
        Department current = repo.findById(id).orElseThrow(() -> new CommonException("not-found-department"));
        return CommonFunctions.generateResponse(ErrorEnum.DEPARTMENT_NOT_FOUND, current.toDTO());
    }

    public StatusResponse getAll(){
        List<Department> lst = repo.findByIsDeleted(Constants.STATUS_INACTIVE);
        List<DepartmentDto> result = toDTOs(lst);
        return CommonFunctions.generateResponse(ErrorEnum.DEPARTMENT_NOT_FOUND, result);
    }
    public StatusResponse getAllByUserId(Integer userId){
        List<Department> lst = repo.findByIsDeletedAndUserId(Constants.STATUS_INACTIVE, userId);
        return CommonFunctions.generateResponse(ErrorEnum.SUCCESS, toDTOs(lst));
    }
    public StatusResponse update(Integer id, DepartmentDto dto){
        Department current = repo.findById(id).orElseThrow(() -> new CommonException("not-found-department"));
        if (!dto.getCreatedBy().equals(current.getCreatedBy())){
            throw new CommonException("you-not-create");
        }
        current.setDepartmentName(dto.getDepartmentName());
        repo.save(current);
        return CommonFunctions.generateResponse(ErrorEnum.DEPARTMENT_NOT_FOUND, current.toDTO());
    }

    public void delete(Integer id, DepartmentDto dto){
        Department current = repo.findById(id).orElseThrow(() -> new CommonException("not-found-department"));
        current.setIsDeleted(Constants.STATUS_ACTIVE);
        repo.save(current);
    }


    public List<DepartmentDto> toDTOs(List<Department> objs) {
        List<DepartmentDto> dtos = new ArrayList<>();
        objs.forEach(obj -> {
            dtos.add(toDTO(obj));
        });
        return dtos;
    }

    /* convert list model object to DTO before response */
    public List<DepartmentDto> from(List<Department> objs) {
        return objs.stream().map(obj -> obj.toDTO()).collect(Collectors.toList());
    }

    /* convert model object to DTO before response */
    public DepartmentDto toDTO(Department obj) {
        return Department.toDTO(obj);
    }
}

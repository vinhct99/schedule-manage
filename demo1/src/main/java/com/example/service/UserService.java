package com.example.service;

import com.example.common.CommonException;
import com.example.common.CommonFunctions;
import com.example.common.Constants;
import com.example.common.ErrorEnum;
import com.example.dto.StatusResponse;
import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
@Service
public class UserService {
    private final  UserRepo _repo;

    private static final String USER_NOT_FOUND = "User not found in system";

    public UserService(UserRepo repo){
        _repo = repo;

    }

    public StatusResponse createUser(UserDto dto) {
        boolean exitsUserName = _repo.findByUserNameAndStatus(dto.getUserName(), Constants.STATUS_ACTIVE).isPresent();
        boolean exitsMobile = _repo.findByMobileAndStatus(dto.getUserName(), Constants.STATUS_ACTIVE).isPresent();
        boolean exitsEmail = _repo.findByEmailAndStatus(dto.getUserName(), Constants.STATUS_ACTIVE).isPresent();
        if (exitsUserName) {
            return CommonFunctions.generateResponse(ErrorEnum.USER_EXIST, null);
        } else if (exitsMobile) {
            return CommonFunctions.generateResponse(ErrorEnum.PHONE_EXIST, null);
        } else if (exitsEmail) {
            return CommonFunctions.generateResponse(ErrorEnum.EMAIL_EXIST, null);
        }

        User addUser = new User();
        addUser.setCreateDate(new Date());
        addUser.setEmail(dto.getEmail());
        addUser.setUserName(dto.getUserName());
        addUser.setPassWord(dto.getPassWord());
        addUser.setDeptId(dto.getDeptId());
        addUser.setEmail(dto.getEmail());
        addUser.setFullName(dto.getFullName());
        addUser.setStatus(Constants.STATUS_ACTIVE);
        addUser.setRole(dto.getRole());

        addUser = _repo.save(addUser);

        return CommonFunctions.generateResponse(ErrorEnum.SUCCESS, addUser);

    }

    public StatusResponse getUser(Integer id) {
        Optional<User> current = _repo.findById(id);
        if (current.isEmpty()) {
            return CommonFunctions.generateResponse(ErrorEnum.USER_NOT_FOUND, null);
        }
        return CommonFunctions.generateResponse(ErrorEnum.SUCCESS, current.get());
    }

    public StatusResponse getAll() {
        List<User> current = _repo.findByStatus(Constants.STATUS_ACTIVE);
        return CommonFunctions.generateResponse(ErrorEnum.SUCCESS, current);
    }

    public StatusResponse updateUser(Integer id, UserDto dto) {
        Optional<User> current = _repo.findById(id);
        if (current.isEmpty()) {
            return CommonFunctions.generateResponse(ErrorEnum.USER_NOT_FOUND, null);
        }
        User userUpdate = current.get();
        userUpdate.setCreateDate(new Date());
        userUpdate.setEmail(dto.getEmail());
        userUpdate.setUserName(dto.getUserName());
        userUpdate.setPassWord(dto.getPassWord());
        userUpdate.setDeptId(dto.getDeptId());
        userUpdate.setEmail(dto.getEmail());
        userUpdate.setFullName(dto.getFullName());
        if (dto.getStatus() == null) {
            userUpdate.setStatus(Constants.STATUS_ACTIVE);
        } else {
            userUpdate.setStatus(dto.getStatus());
        }
        userUpdate.setRole(dto.getRole());

        boolean exitsUserName = _repo.findByUserNameAndStatus(dto.getUserName(), Constants.STATUS_ACTIVE).isPresent();
        boolean exitsMobile = _repo.findByMobileAndStatus(dto.getUserName(), Constants.STATUS_ACTIVE).isPresent();
        boolean exitsEmail = _repo.findByEmailAndStatus(dto.getUserName(), Constants.STATUS_ACTIVE).isPresent();
        if (exitsUserName) {
            return CommonFunctions.generateResponse(ErrorEnum.USER_EXIST, null);
        } else if (exitsMobile) {
            return CommonFunctions.generateResponse(ErrorEnum.PHONE_EXIST, null);
        } else if (exitsEmail) {
            return CommonFunctions.generateResponse(ErrorEnum.EMAIL_EXIST, null);
        }
        userUpdate = _repo.save(userUpdate);
        return CommonFunctions.generateResponse(ErrorEnum.SUCCESS, dto);
    }

    public boolean checkRole(String userName) throws Exception {
        boolean checkRole = true;
        Optional<User> current = _repo.findByUserNameAndStatus(userName, Constants.STATUS_ACTIVE);
        if (current.isEmpty()) {
            throw new Exception(USER_NOT_FOUND);
        }
        User user = current.get();
        if (user.getRole() == Constants.ROLE_ADMIN) {
            checkRole = true;
            return checkRole;
        } else {
            checkRole = false;
            return checkRole;
        }
    }

    public StatusResponse login(String userName, String passWord) {
        Optional<User> current = _repo.findByUserNameAndStatus(userName, Constants.STATUS_ACTIVE);
        if (!current.isEmpty()) {
            User user = current.get();
            if (!user.getPassWord().equals(passWord)) {
               return CommonFunctions.generateResponse(ErrorEnum.PASSWORD_INVALID, null);
            }
            else {
                return CommonFunctions.generateResponse(ErrorEnum.SUCCESS, current);
            }
        } else {
            return CommonFunctions.generateResponse(ErrorEnum.USER_NOT_FOUND, null);
        }
    }

    public List<UserDto> toDTOs(List<User> objs) {
        List<UserDto> dtos = new ArrayList<>();
        objs.forEach(obj -> {
            dtos.add(toDTO(obj));
        });
        return dtos;
    }

    /* convert list model object to DTO before response */
    public List<UserDto> from(List<User> objs) {
        return objs.stream().map(obj -> obj.toDTO()).collect(Collectors.toList());
    }

    /* convert model object to DTO before response */
    public UserDto toDTO(User obj) {
        return User.toDTO(obj);
    }
}

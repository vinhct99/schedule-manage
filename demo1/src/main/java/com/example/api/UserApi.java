package com.example.api;

import com.example.dto.StatusResponse;
import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserApi {
    @Autowired
    UserService service;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto dto) {
        StatusResponse result = service.login(dto.getUserName(), dto.getPassWord());
        return ResponseEntity.status(result.getStatus()).body(result);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDto dto) {
        StatusResponse result = service.createUser(dto);
        return ResponseEntity.status(result.getStatus()).body(result);
    }


    @PutMapping("/role/{id}")
    public ResponseEntity<?> updateRole(@PathVariable int id, @RequestBody UserDto dto){
        StatusResponse result = service.updateUser(id, dto);
        return ResponseEntity.status(result.getStatus()).body(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody UserDto dto){
        StatusResponse result = service.updateUser(id, dto);
        return ResponseEntity.status(result.getStatus()).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id){
        StatusResponse result = service.getUser(id);
        return ResponseEntity.status(result.getStatus()).body(result);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(){
        StatusResponse result = service.getAll();
        return ResponseEntity.status(result.getStatus()).body(result);
    }

}

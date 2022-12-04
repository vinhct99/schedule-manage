package com.example.api;

import com.example.dto.ScheduleDto;
import com.example.dto.StatusResponse;
import com.example.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleApi {
    
    @Autowired
    ScheduleService service;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody ScheduleDto dto) throws Exception {
        StatusResponse result = service.createSchedule(dto);
        return ResponseEntity.status(result.getStatus()).body(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody ScheduleDto dto) throws Exception {
        StatusResponse result = service.updateSchedule(id, dto);
        return ResponseEntity.status(result.getStatus()).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id) throws Exception {
        StatusResponse result = service.getById(id);
        return ResponseEntity.status(result.getStatus()).body(result);
    }

    @GetMapping("/accept/{id}")
    public ResponseEntity<?> accept(@PathVariable int id) throws Exception {
        StatusResponse result = service.acceptVis(id);
        return ResponseEntity.status(result.getStatus()).body(result);
    }

    @GetMapping("/disable/{id}")
    public ResponseEntity<?> disable(@PathVariable int id) throws Exception {
        StatusResponse result = service.delete(id);
        return ResponseEntity.status(result.getStatus()).body(result);
    }

    @GetMapping("/publísh/{id}")
    public ResponseEntity<?> publish(@PathVariable int id) throws Exception {
        StatusResponse result = service.publish(id);
        return ResponseEntity.status(result.getStatus()).body(result);
    }

    @GetMapping("/get-by-depId/{id}")
    public ResponseEntity<?> getByDepId(@PathVariable int id) throws Exception {
        StatusResponse result = service.getAllByDepart(id);
        return ResponseEntity.status(result.getStatus()).body(result);
    }


    @GetMapping("/get-publish-by-depId/{id}")
    public ResponseEntity<?> getPublishByDepId(@PathVariable int id) throws Exception {
        StatusResponse result = service.getAllPublishPBByDepart(id);
        return ResponseEntity.status(result.getStatus()).body(result);
    }


    @GetMapping("/get-all-publish-company")
    public ResponseEntity<?> getAllPublishCompany() throws Exception {
        StatusResponse result = service.getAllPublishCC();
        return ResponseEntity.status(result.getStatus()).body(result);
    }


    @GetMapping("/get-list-approve")
    public ResponseEntity<?> getListApprove() throws Exception {
        StatusResponse result = service.getAllNotPublishCC();
        return ResponseEntity.status(result.getStatus()).body(result);
    }


}

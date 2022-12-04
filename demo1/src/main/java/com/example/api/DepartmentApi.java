package com.example.api;
import com.example.dto.DepartmentDto;
import com.example.dto.StatusResponse;
import com.example.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentApi {
    @Autowired
    DepartmentService service;
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody DepartmentDto dto) throws Exception {
        StatusResponse result = service.createDepartment(dto);
        return ResponseEntity.status(result.getStatus()).body(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody DepartmentDto dto){
        StatusResponse result = service.update(id, dto);
        return ResponseEntity.status(result.getStatus()).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id){
        StatusResponse result = service.getById(id);
        return ResponseEntity.status(result.getStatus()).body(result);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(){
        StatusResponse result = service.getAll();
        return ResponseEntity.status(result.getStatus()).body(result);
    }

    @GetMapping("/get-by-nameId/{id}")
    public ResponseEntity<?> getAllByUserId(@PathVariable int id) throws Exception {
        StatusResponse result = service.getAllByUserId(id);
        return ResponseEntity.status(result.getStatus()).body(result);
    }
}

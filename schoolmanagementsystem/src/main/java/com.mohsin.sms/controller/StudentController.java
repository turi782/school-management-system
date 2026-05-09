package com.mohsin.sms.controller;
import com.mohsin.sms.dto.StudentDTO;
import com.mohsin.sms.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.mohsin.sms.payload.ApiResponse;

import java.util.List;git

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<StudentDTO>> create(@Valid @RequestBody StudentDTO dto) {
        StudentDTO created = service.createStudent(dto);
        ApiResponse<StudentDTO> response =
                new ApiResponse<>("Student created successfully", created, 201);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public List<StudentDTO> getAll() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentDTO getById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public StudentDTO update(@PathVariable Long id, @RequestBody StudentDTO dto) {
        return service.updateStudent(id,dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteStudent(id);
        return "Task deleted successfully";
    }
}

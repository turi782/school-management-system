package com.mohsin.sms.controller;

import com.mohsin.sms.dto.TeacherDTO;
import com.mohsin.sms.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")

public class TeacherController {
    private final TeacherService service;

    public TeacherController(TeacherService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public TeacherDTO create(@RequestBody TeacherDTO dto) {
        return service.createTeacher(dto);
    }

    // GET ALL
    @GetMapping
    public List<TeacherDTO> getAll() {
        return service.getAllTeachers();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public TeacherDTO getById(@PathVariable Long id) {
        return service.getTeacherById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public TeacherDTO update(@PathVariable Long id,
                             @RequestBody TeacherDTO dto) {

        return service.updateTeacher(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteTeacher(id);
    }

}

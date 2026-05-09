package com.mohsin.sms.controller;

import com.mohsin.sms.dto.CourseDTO;
import com.mohsin.sms.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public CourseDTO create(@RequestBody CourseDTO dto) {
        return service.createCourse(dto);
    }

    // GET ALL
    @GetMapping
    public List<CourseDTO> getAll() {
        return service.getAllCourses();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public CourseDTO getById(@PathVariable Long id) {
        return service.getCourseById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public CourseDTO update(@PathVariable Long id, @RequestBody CourseDTO dto) {
        return service.updateCourse(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteCourse(id);
        return "Course deleted successfully";
    }
}

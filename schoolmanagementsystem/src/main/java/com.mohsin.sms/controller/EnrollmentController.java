package com.mohsin.sms.controller;

import com.mohsin.sms.dto.EnrollmentDTO;
import com.mohsin.sms.entity.Enrollment;
import com.mohsin.sms.service.EnrollmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {
    private final EnrollmentService service;

    public EnrollmentController(EnrollmentService service) {
        this.service = service;
    }

    @PostMapping
    public Enrollment enroll(@RequestBody EnrollmentDTO dto) {
        return service.enrollStudent(dto);
    }

}

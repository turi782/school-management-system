package com.mohsin.sms.controller;

import com.mohsin.sms.dto.AttendanceDTO;
import com.mohsin.sms.entity.Attendance;
import com.mohsin.sms.service.AttendanceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceService service;

    public AttendanceController(AttendanceService service) {
        this.service = service;
    }

    @PostMapping
    public Attendance markAttendance(
            @RequestBody AttendanceDTO dto
    ) {
        return service.markAttendance(dto);
    }
}

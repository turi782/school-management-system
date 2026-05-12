package com.mohsin.sms.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class AttendanceDTO {
    private Long studentId;

    private Long courseId;

    private LocalDate date;

    private boolean present;

}

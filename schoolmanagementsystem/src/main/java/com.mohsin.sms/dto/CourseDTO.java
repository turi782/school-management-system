package com.mohsin.sms.dto;

import lombok.Data;

@Data
public class CourseDTO {

    private Long id;
    private String title;
    private String description;
    private Long teacherId;
    private String teacherName;
}

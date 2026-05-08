package com.mohsin.sms.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class CourseDTO {

    private Long id;
    private String title;
    private String description;
    private String instructorName;
}

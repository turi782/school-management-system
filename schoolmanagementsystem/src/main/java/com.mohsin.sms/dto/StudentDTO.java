package com.mohsin.sms.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class StudentDTO {

    private Long id;
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    private String email;

    private String grade;
}

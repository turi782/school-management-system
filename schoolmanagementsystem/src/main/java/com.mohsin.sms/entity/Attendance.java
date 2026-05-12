package com.mohsin.sms.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

import lombok.*;

@Data
@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private boolean present;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}

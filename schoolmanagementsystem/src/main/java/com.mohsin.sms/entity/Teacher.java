package com.mohsin.sms.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;
import java.util.List;

@Data
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String subject;

    @JsonManagedReference
    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;


}

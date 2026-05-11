package com.mohsin.sms.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String subject;

}

package com.mohsin.sms.mapper;

import com.mohsin.sms.dto.TeacherDTO;
import com.mohsin.sms.entity.Teacher;

public class TeacherMapper {

    public static TeacherDTO toDTO(Teacher teacher) {

        TeacherDTO dto = new TeacherDTO();

        dto.setId(teacher.getId());
        dto.setName(teacher.getName());
        dto.setEmail(teacher.getEmail());
        dto.setSubject(teacher.getSubject());

        return dto;
    }

    public static Teacher toEntity(TeacherDTO dto) {

        Teacher teacher = new Teacher();

        teacher.setId(dto.getId());
        teacher.setName(dto.getName());
        teacher.setEmail(dto.getEmail());
        teacher.setSubject(dto.getSubject());

        return teacher;
    }
}

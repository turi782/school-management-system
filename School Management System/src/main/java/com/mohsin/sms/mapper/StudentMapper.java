package com.mohsin.sms.mapper;
import com.mohsin.sms.dto.StudentDTO;
import com.mohsin.sms.entity.Student;

public class StudentMapper {

    public static StudentDTO toDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setGrade(student.getGrade());
        return dto;
    }

    public static Student toEntity(StudentDTO dto) {
        Student student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setGrade(dto.getGrade());
        return student;
    }
}

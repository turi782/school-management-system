package com.mohsin.sms.mapper;


import com.mohsin.sms.dto.CourseDTO;
import com.mohsin.sms.entity.Course;

public class CourseMapper {

    public static CourseDTO toDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setDescription(course.getDescription());
        dto.setInstructorName(course.getInstructorName());
        return dto;
    }

    public static Course toEntity(CourseDTO dto) {
        Course course = new Course();
        course.setId(dto.getId());
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setInstructorName(dto.getInstructorName());
        return course;
    }
}

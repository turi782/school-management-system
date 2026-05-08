package com.mohsin.sms.service;

import com.mohsin.sms.dto.CourseDTO;
import com.mohsin.sms.entity.Course;
import com.mohsin.sms.mapper.CourseMapper;
import com.mohsin.sms.repository.CourseRepository;
import org.springframework.stereotype.Service;
import com.mohsin.sms.exception.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CourseService {


    private final CourseRepository repo;

    public CourseService(CourseRepository repo) {
        this.repo = repo;
    }

    // CREATE
    public CourseDTO createCourse(CourseDTO dto) {
        Course course = CourseMapper.toEntity(dto);
        return CourseMapper.toDTO(repo.save(course));
    }

    // GET ALL
    public List<CourseDTO> getAllCourses() {
        return repo.findAll()
                .stream()
                .map(CourseMapper::toDTO)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public CourseDTO getCourseById(Long id) {
        Course course = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return CourseMapper.toDTO(course);
    }

    // UPDATE
    public CourseDTO updateCourse(Long id, CourseDTO dto) {
        Course course = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setInstructorName(dto.getInstructorName());

        return CourseMapper.toDTO(repo.save(course));
    }

    // DELETE By Id
    public void deleteCourse(Long id) {
         Course course =repo.findById(id)
             .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
    }

}

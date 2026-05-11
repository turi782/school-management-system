package com.mohsin.sms.service;

import com.mohsin.sms.dto.CourseDTO;
import com.mohsin.sms.entity.Course;
import com.mohsin.sms.entity.Teacher;
import com.mohsin.sms.mapper.CourseMapper;
import com.mohsin.sms.repository.CourseRepository;
import com.mohsin.sms.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import com.mohsin.sms.exception.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CourseService {

    private final TeacherRepository teacherRepo;
    private final CourseRepository repo;

    public CourseService(CourseRepository repo,TeacherRepository teacherRepo) {
        this.repo = repo;
        this.teacherRepo = teacherRepo;
    }

    // CREATE
    public CourseDTO createCourse(CourseDTO dto) {

        Teacher teacher = teacherRepo.findById(dto.getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        Course course = new Course();

        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());

        // assign teacher
        course.setTeacher(teacher);

        Course saved = repo.save(course);

        CourseDTO response = new CourseDTO();

        response.setId(saved.getId());
        response.setTitle(saved.getTitle());
        response.setDescription(saved.getDescription());

        response.setTeacherId(teacher.getId());
        response.setTeacherName(teacher.getName());

        return response;
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
        return CourseMapper.toDTO(repo.save(course));
    }

    // DELETE By Id
    public void deleteCourse(Long id) {
         Course course =repo.findById(id)
             .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
    }

}

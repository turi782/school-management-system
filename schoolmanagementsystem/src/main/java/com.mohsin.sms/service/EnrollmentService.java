package com.mohsin.sms.service;

import com.mohsin.sms.dto.EnrollmentDTO;
import com.mohsin.sms.entity.Course;
import com.mohsin.sms.entity.Enrollment;
import com.mohsin.sms.entity.Student;
import com.mohsin.sms.repository.CourseRepository;
import com.mohsin.sms.repository.EnrollmentRepository;
import com.mohsin.sms.repository.StudentRepository;
import org.springframework.stereotype.Service;


@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepo;
    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;

    public EnrollmentService(
            EnrollmentRepository enrollmentRepo,
            StudentRepository studentRepo,
            CourseRepository courseRepo
    ) {
        this.enrollmentRepo = enrollmentRepo;
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    public Enrollment enrollStudent(EnrollmentDTO dto) {

        Student student = studentRepo.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepo.findById(dto.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Enrollment enrollment = new Enrollment();

        enrollment.setStudent(student);
        enrollment.setCourse(course);

        return enrollmentRepo.save(enrollment);
    }
}

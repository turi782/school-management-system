package com.mohsin.sms.service;

import com.mohsin.sms.dto.AttendanceDTO;
import com.mohsin.sms.entity.Attendance;
import com.mohsin.sms.entity.Course;
import com.mohsin.sms.entity.Student;
import com.mohsin.sms.repository.AttendanceRepository;
import com.mohsin.sms.repository.CourseRepository;
import com.mohsin.sms.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {
    private final AttendanceRepository attendanceRepo;
    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;

    public AttendanceService(
            AttendanceRepository attendanceRepo,
            StudentRepository studentRepo,
            CourseRepository courseRepo
    ) {
        this.attendanceRepo = attendanceRepo;
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    public Attendance markAttendance(AttendanceDTO dto) {

        Student student = studentRepo.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepo.findById(dto.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Attendance attendance = new Attendance();

        attendance.setStudent(student);
        attendance.setCourse(course);
        attendance.setDate(dto.getDate());
        attendance.setPresent(dto.isPresent());

        return attendanceRepo.save(attendance);
    }
}

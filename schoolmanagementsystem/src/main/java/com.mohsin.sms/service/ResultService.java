package com.mohsin.sms.service;


import com.mohsin.sms.dto.ResultDTO;
import com.mohsin.sms.entity.Course;
import com.mohsin.sms.entity.Result;
import com.mohsin.sms.entity.Student;
import com.mohsin.sms.repository.CourseRepository;
import com.mohsin.sms.repository.ResultRepository;
import com.mohsin.sms.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class ResultService {

    private final ResultRepository resultRepo;
    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;

    public ResultService(
            ResultRepository resultRepo,
            StudentRepository studentRepo,
            CourseRepository courseRepo
    ) {
        this.resultRepo = resultRepo;
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    public Result addResult(ResultDTO dto) {

        Student student = studentRepo.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepo.findById(dto.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Result result = new Result();

        result.setStudent(student);
        result.setCourse(course);
        result.setMarks(dto.getMarks());

        // grade logic
        result.setGrade(calculateGrade(dto.getMarks()));

        return resultRepo.save(result);
    }

    private String calculateGrade(double marks) {

        if (marks >= 90) return "A+";
        if (marks >= 80) return "A";
        if (marks >= 70) return "B";
        if (marks >= 60) return "C";
        if (marks >= 50) return "D";

        return "F";
    }

}

package com.mohsin.sms.service;
import com.mohsin.sms.entity.Course;
import com.mohsin.sms.entity.Student;
import com.mohsin.sms.mapper.StudentMapper;
import com.mohsin.sms.repository.StudentRepository;
import org.springframework.stereotype.Service;
import com.mohsin.sms.exception.ResourceNotFoundException;
import com.mohsin.sms.dto.StudentDTO;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public StudentDTO createStudent(StudentDTO dto) {
        Student student = StudentMapper.toEntity(dto);
        return StudentMapper.toDTO(repo.save(student));
    }

    public List<StudentDTO> getAllStudents() {
        return repo.findAll()
                .stream()
                .map(StudentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public StudentDTO getStudentById(Long id) {
        Student student = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return StudentMapper.toDTO(student);
    }

    public StudentDTO updateStudent(Long id, StudentDTO dto) {
        Student student = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setGrade(dto.getGrade());

        return StudentMapper.toDTO(repo.save(student));
    }

    public void deleteStudent(Long id) {
        Student student = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        repo.delete(student);
    }

}

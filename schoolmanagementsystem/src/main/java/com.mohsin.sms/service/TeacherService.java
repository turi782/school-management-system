package com.mohsin.sms.service;

import com.mohsin.sms.dto.TeacherDTO;
import com.mohsin.sms.entity.Teacher;
import com.mohsin.sms.mapper.TeacherMapper;
import com.mohsin.sms.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {
    private final TeacherRepository repo;

    public TeacherService(TeacherRepository repo) {
        this.repo = repo;
    }

    // CREATE
    public TeacherDTO createTeacher(TeacherDTO dto) {

        Teacher teacher = TeacherMapper.toEntity(dto);

        return TeacherMapper.toDTO(repo.save(teacher));
    }

    // GET ALL
    public List<TeacherDTO> getAllTeachers() {

        return repo.findAll()
                .stream()
                .map(TeacherMapper::toDTO)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public TeacherDTO getTeacherById(Long id) {

        Teacher teacher = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        return TeacherMapper.toDTO(teacher);
    }

    // UPDATE
    public TeacherDTO updateTeacher(Long id, TeacherDTO dto) {

        Teacher teacher = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        teacher.setName(dto.getName());
        teacher.setEmail(dto.getEmail());
        teacher.setSubject(dto.getSubject());

        return TeacherMapper.toDTO(repo.save(teacher));
    }

    // DELETE
    public void deleteTeacher(Long id) {
        repo.deleteById(id);
    }

}

package com.example.StudentAppApplication.service;

import com.example.StudentAppApplication.entity.Student;
import com.example.StudentAppApplication.exception.ResourceNotFoundException;
import com.example.StudentAppApplication.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student getStudentById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    public Student updateStudent(Long id, Student updated) {
        Student student = getStudentById(id);
        student.setName(updated.getName());
        student.setEmail(updated.getEmail());
        student.setCourse(updated.getCourse());
        return repo.save(student);
    }

    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        repo.delete(student);
    }
}
package com.example.StudentAppApplication.repository;

import com.example.StudentAppApplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
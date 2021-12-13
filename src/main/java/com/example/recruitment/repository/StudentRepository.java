package com.example.recruitment.repository;

import com.example.recruitment.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {

    Optional<Object> findByNameAndSurname(String s, String s1);
}

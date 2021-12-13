package com.example.recruitment.repository;

import com.example.recruitment.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TeacherRepository extends JpaRepository<Teacher,Long> {

    Optional<Teacher> findByNameAndSurname(String name, String surname);
}

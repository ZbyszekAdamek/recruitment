package com.example.recruitment.controller;

import com.example.recruitment.dto.StudentDto;
import com.example.recruitment.dto.TeacherDto;
import com.example.recruitment.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping()
    public Page<StudentDto> getStudents(@RequestParam Optional<Integer> page, @RequestParam Optional<String> sortBy) {
        return studentService.listOfStudents(page, sortBy);
    }

    @GetMapping("/{fullName}")
    public StudentDto getByFullName(@PathVariable String fullName) {
        return studentService.findByNameAndSurname(fullName);
    }

    @GetMapping("/{id}/teachers")
    public List<TeacherDto> getTeacherTeachingStudent(@PathVariable Long id) {
        return studentService.getTeacherTeachingStudent(id);
    }
}








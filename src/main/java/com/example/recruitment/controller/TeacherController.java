package com.example.recruitment.controller;

import com.example.recruitment.dto.StudentDto;
import com.example.recruitment.dto.TeacherDto;
import com.example.recruitment.entity.Teacher;
import com.example.recruitment.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping()
    public Page<TeacherDto> getTeachers(@RequestParam Optional<Integer> page, @RequestParam Optional<String> sortBy){
        return teacherService.listOfTeachers(page, sortBy);
    }

    @GetMapping("/{fullName}")
    public TeacherDto getByFullName(@PathVariable String fullName){
        return teacherService.findByNameAndSurname(fullName);
    }

    @GetMapping("/{id}/students")
    public List<StudentDto> getStudentTeachedByTeacher(@PathVariable Long id){
    return teacherService.getStudentTeachedByTeacher(id);
    }

    @GetMapping("/add")
    public String initAddFom(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "/addTeacher";
    }

    @PostMapping("/add")
    public String persistTeacher(Teacher teacher, BindingResult result) {
        if (result.hasErrors()) {
            return "/addTeacher";
        }
        try {
            teacherService.saveTeacher(teacher);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/teachers";
    }
}

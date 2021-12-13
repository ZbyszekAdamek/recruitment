package com.example.recruitment.controller;

import com.example.recruitment.dao.StudentDao;
import com.example.recruitment.entity.Student;
import com.example.recruitment.service.StudentService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class CrudStudentController {

    private final StudentService studentService;
    private final StudentDao studentDao;

    public CrudStudentController(StudentService studentService, StudentDao studentDao) {
        this.studentService = studentService;
        this.studentDao = studentDao;
    }


    @GetMapping("/addStudent")
    public String initAddFom(Model model) {
        model.addAttribute("student", new Student());
        return "/addStudent";
    }

    @PostMapping("/addStudent")
    public String persistTeacher(Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "/addStudent";
        }
        try {
            studentService.saveStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/students";
    }

    @GetMapping("/removeStudent")
    public String prepareRemove(@RequestParam int toRemoveId, Model model) {
        model.addAttribute("student", studentDao.findById(toRemoveId));
        return "removeStudent";
    }

    @PostMapping("/removeStudent")
    public String remove(@RequestParam String confirmed, @RequestParam int toRemoveId) {
        if ("yes".equals(confirmed)) {
            Student student = studentDao.findById(toRemoveId);
            studentDao.delete(student);
        }
        return "redirect:/students";
    }

    @GetMapping("/editStudent")
    public String prepareEdit(@RequestParam int idToEdit, Model model) {
        model.addAttribute("student", studentDao.findById(idToEdit));
        return "addStudent";
    }

    @PostMapping("/editStudent")
    public String merge(Student student) {
        studentDao.update(student);
        return "redirect:/students";
    }
    @GetMapping("/listStudents")
    public String showAll(Model model) {
        try {
            model.addAttribute("allStudents", studentService.FindAllStudents());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "listStudents";
    }
}

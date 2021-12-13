package com.example.recruitment.controller;

import com.example.recruitment.dao.TeacherDao;
import com.example.recruitment.entity.Teacher;
import com.example.recruitment.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CrudTeacherController {

    private final TeacherService teacherService;
    private final TeacherDao teacherDao;

    public CrudTeacherController(TeacherService teacherService, TeacherDao teacherDao) {
        this.teacherService = teacherService;
        this.teacherDao = teacherDao;
    }
    @GetMapping("/addTeacher")
    public String initAddFom(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "/addTeacher";
    }

    @PostMapping("/addTeacher")
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
    @GetMapping("/removeTeacher")
    public String prepareRemove(@RequestParam int toRemoveId, Model model) {
        model.addAttribute("teacher", teacherDao.findById(toRemoveId));
        return "removeTeacher";
    }

    @PostMapping("/removeTeacher")
    public String remove(@RequestParam String confirmed, @RequestParam int toRemoveId) {
        if ("yes".equals(confirmed)) {
            Teacher teacher = teacherDao.findById(toRemoveId);
            teacherDao.delete(teacher);
        }
        return "redirect:/teachers";
    }
    @GetMapping("/editTeacher")
    public String prepareEdit(@RequestParam int idToEdit, Model model) {
        model.addAttribute("teacher", teacherDao.findById(idToEdit));
        return "addTeacher";
    }

    @PostMapping("/editTeacher")
    public String merge(Teacher teacher) {
        teacherDao.update(teacher);
        return "redirect:/teachers";
    }
    @GetMapping("/listTeachers")
    public String showAll(Model model) {
        try {
            model.addAttribute("allTeachers", teacherService.FindAllTeachers());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "listTeachers";
    }

}

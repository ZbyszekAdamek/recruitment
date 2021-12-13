package com.example.recruitment.service;

import com.example.recruitment.controller.TeacherNotFoundException;
import com.example.recruitment.dao.TeacherDao;
import com.example.recruitment.dto.StudentDto;
import com.example.recruitment.dto.TeacherDto;
import com.example.recruitment.entity.Teacher;
import com.example.recruitment.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private static final int PAGE_SIZE = 10;
    private final TeacherDao teacherDao;
    private final TeacherDto teacherDto;

    public Page<TeacherDto> listOfTeachers(Optional<Integer> page, Optional<String> sortBy) {
        List<TeacherDto> teachers = teacherRepository
                .findAll(PageRequest.of(page.orElse(0), 3, Sort.Direction.ASC, sortBy.orElse("id")))
                .map(teacher -> new TeacherDto(teacher.getId(), teacher.getName(), teacher.getSurname(), teacher.getAge(), teacher.getEmail(), teacher.getSubject()))
                .stream().collect(Collectors.toList());
        return new PageImpl<TeacherDto>(teachers);
    }

    public TeacherDto findByNameAndSurname(String fullName) {
        String[] splittedFullName = fullName.split(" ");
        Teacher teacher = teacherRepository.findByNameAndSurname(splittedFullName[0], splittedFullName[1]).orElseThrow(() -> new TeacherNotFoundException(String.format("Nauczyciel %s %s nie istnieje", splittedFullName[0], splittedFullName[1])));
        return new TeacherDto(teacher.getId(), teacher.getName(), teacher.getSurname(), teacher.getAge(), teacher.getEmail(), teacher.getSubject());
    }

    public List<StudentDto> getStudentTeachedByTeacher(Long id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new TeacherNotFoundException(String.format("Nauczyciel o ID %s nie istnieje", id)));
        return teacher.getStudents().stream().map(student -> new StudentDto(student.getId(), student.getName(), student.getSurname(), student.getEmail(), student.getCourse())).collect(Collectors.toList());
    }
    public void saveTeacher(Teacher teacher) {
        teacherDao.createTeacher(teacher);
    }
    public List FindAllTeachers(){
        return teacherDao.findAll();
    }
}

package com.example.recruitment.service;

import com.example.recruitment.controller.StudentNotFoundException;
import com.example.recruitment.controller.TeacherNotFoundException;
import com.example.recruitment.dao.StudentDao;
import com.example.recruitment.dao.TeacherDao;
import com.example.recruitment.dto.StudentDto;
import com.example.recruitment.dto.TeacherDto;
import com.example.recruitment.entity.Student;
import com.example.recruitment.entity.Teacher;
import com.example.recruitment.repository.StudentRepository;
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
public class StudentService {

    private final StudentRepository studentRepository;
    private static final int PAGE_SIZE = 10;
    private final TeacherDao teacherDao;
    private final TeacherDto teacherDto;
    private final StudentDao studentDao;

    public Page<StudentDto> listOfStudents(Optional<Integer> page, Optional<String> sortBy) {
        List<StudentDto> students = studentRepository
                .findAll(PageRequest.of(page.orElse(0), 3, Sort.Direction.ASC, sortBy.orElse("id")))
                .map(student -> new StudentDto(student.getId(), student.getName(), student.getSurname(), student.getEmail(), student.getCourse()))
                .stream().collect(Collectors.toList());
        return new PageImpl<StudentDto>(students);
    }

    public StudentDto findByNameAndSurname(String fullName) {
        String[] splittedFullName = fullName.split(" ");
        Student student = (Student) studentRepository.findByNameAndSurname(splittedFullName[0], splittedFullName[1]).orElseThrow(() -> new TeacherNotFoundException(String.format("Nauczyciel %s %s nie istnieje", splittedFullName[0], splittedFullName[1])));
        return new StudentDto(student.getId(), student.getName(), student.getSurname(), student.getEmail(), student.getCourse());
    }

    public List<TeacherDto> getTeacherTeachingStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(String.format("Student o ID %s nie istnieje", id)));
        return student.getTeachers().stream().map(teacher -> new TeacherDto(teacher.getId(), teacher.getName(), teacher.getSurname(), teacher.getAge(), teacher.getEmail(), teacher.getSubject())).collect(Collectors.toList());
    }
    public void saveStudent(Student student) {
        studentDao.createStudent(student);
    }
    public List FindAllStudents(){
        return studentDao.findAll();
    }
}

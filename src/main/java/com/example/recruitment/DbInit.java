package com.example.recruitment;

import com.example.recruitment.entity.Student;
import com.example.recruitment.entity.Teacher;
import com.example.recruitment.repository.StudentRepository;
import com.example.recruitment.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DbInit implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;


    @Override
    public void run(String... args) throws Exception {
//        Student student1 = new Student("Jan", "Nowak", "Jank@wp.pl", "przyroda");
//        Student student2 = new Student("Karol", "Nowak", "Karol@wp.pl", "wf");
//        Student student3 = new Student("ELA", "Zieleniak", "elza@onet.pl", "przyroda");
//        Student student4 = new Student("Robert", "Błaszczak", "Robert@wp.pl", "przyroda");
//
//        studentRepository.saveAll(Arrays.asList(student1,student2,student3,student4));
//
//        Teacher teacher = new Teacher("Rafał", "Kowalski", 35, "rafal@gmail.com", "przyroda");
//        Teacher teacher1 = new Teacher("Rafał", "Nowak", 35, "rafal1@gmail.com", "przyroda");
//        Teacher teacher2 = new Teacher("Karol", "Kowalski", 37, "karol@gmail.com", "matematyka");
//        Teacher teacher3 = new Teacher("Daniel", "Polski", 25, "daniel@gmail.com", "przyroda");
//
//        teacherRepository.saveAll(Arrays.asList(teacher, teacher1, teacher2, teacher3));


//        List<Teacher> teachers = teacherRepository.findAll();
//        List<Student> students = studentRepository.findAll();
//        int temp = 0;
//        HashSet<Teacher> teachersPerStudent;
//        for (int i = 0; i < students.size(); i++) {
//            teachersPerStudent = new HashSet<>();
//            for (int j = 0; j < teachers.size(); j++) {
//                if (temp!=j){
//                    teachersPerStudent.add(teachers.get(j));
//                }
//                students.get(j).setTeachers(teachersPerStudent);
//                studentRepository.save(students.get(j));
//                temp++;
//            }
//        }
    }
}

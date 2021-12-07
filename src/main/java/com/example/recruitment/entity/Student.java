package com.example.recruitment.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "students")
public class Student {

    @Id
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String course;

    @ManyToMany(
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}
    )
    @JoinTable(
            name = "students_teachers",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private Set<Teacher> teachers = new HashSet<>();



    public Student() {
    }

    public Student(Long id, String name, String surname, String email, String course) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.course = course;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
        teacher.getStudents().add(this);
    }

    public void removeTeacher(Teacher teacher) {
        this.teachers.remove(teacher);
        teacher.getStudents().remove(this);
    }

    public Set<Teacher> getTeachers() {
        return this.teachers;
    }

    public void setTeachers(final Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}

package com.example.recruitment.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Student {

    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String course;
    private Long id;
    @ManyToMany
    private List<Teacher> teachers;

    public Student(String name, String surname, Integer age, String email, String course, Long id, List<Teacher> teachers) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.course = course;
        this.id = id;
        this.teachers = teachers;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String studentName) {
        if(studentName.length() < 2){
            throw new IllegalArgumentException();
        }
        this.name = studentName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer ageParameter) {
        if(ageParameter < 18){
            throw new IllegalArgumentException();
        }
        this.age = ageParameter;
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

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", course='" + course + '\'' +
                ", id=" + id +
                ", teachers=" + teachers +
                '}';
    }
}

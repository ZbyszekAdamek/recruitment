package com.example.recruitment.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "teachers")
public class Teacher {

    @Id
    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String subject;

    @ManyToMany(mappedBy = "teachers")
    private Set<Student> students = new HashSet<>();

    public Teacher(Long id, String name, String surname, Integer age, String email, String subject) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.subject = subject;
    }

    public Teacher() {
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

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    public Set<Student> getStudents() {
        return this.students;
    }

    public void setStudents(final Set<Student> students) {
        this.students = students;
    }
}

package com.example.recruitment.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public void setAge(Integer ageParameter) {
        if(ageParameter < 18){
            throw new IllegalArgumentException();
        }
        this.age = ageParameter;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String teacherEmail) {
        Pattern p = Pattern.compile("[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}");
        Matcher m = p.matcher(teacherEmail);

        boolean matchFound = m.matches();
        if(matchFound){
            this.email = teacherEmail;
        }
        else throw new IllegalArgumentException();
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

    public void setName(final String teacherName) {
        if(teacherName.length() < 2){
            throw new IllegalArgumentException();
        }
        this.name = teacherName;
    }

    public Set<Student> getStudents() {
        return this.students;
    }

    public void setStudents(final Set<Student> students) {
        this.students = students;
    }
}

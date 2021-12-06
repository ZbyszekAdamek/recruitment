package com.example.recruitment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
public class Teacher {

    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String subject;
    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany(targetEntity = Student.class)
    private List<Student> students;

    public Teacher(String name, String surname, Integer age, String email, String subject, Long id, List<Student> students) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.subject = subject;
        this.id = id;
        this.students = students;
    }

    public Teacher() {

    }

    public String getName() {
        return name;
    }

    public void setName(String teacherName) {
        if (teacherName.length() < 2) {
            throw new IllegalArgumentException();
        }
        this.name = teacherName;
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
        if (ageParameter < 18) {
            throw new IllegalArgumentException();
        }
        this.age = ageParameter;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String teacherEmail) {
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher m = p.matcher(teacherEmail);

        boolean matchFound = m.matches();

        if (matchFound) {
            this.email = teacherEmail;
        } else throw new IllegalArgumentException();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
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
        return "Teacher{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                ", id=" + id +
                ", students=" + students +
                '}';
    }
}

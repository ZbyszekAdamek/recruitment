package com.example.recruitment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Service
public class TeacherDto {

    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String subject;
}

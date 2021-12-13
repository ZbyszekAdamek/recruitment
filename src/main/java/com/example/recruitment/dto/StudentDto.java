package com.example.recruitment.dto;

import lombok.*;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Service
public class StudentDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String course;

}

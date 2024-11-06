package com.jdc.taco.learningcriteriaquery.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Embeddable
@Data
public class StudentPk {

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "registration_date")
    private LocalDate registrationDate;
}

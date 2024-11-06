package com.jdc.taco.learningcriteriaquery.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Student {

    @EmbeddedId
    private StudentPk id;

    private String name;
    private String email;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @ManyToOne
    private Section section;
}

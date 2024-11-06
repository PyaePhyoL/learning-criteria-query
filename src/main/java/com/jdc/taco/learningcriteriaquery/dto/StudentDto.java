package com.jdc.taco.learningcriteriaquery.dto;


import com.jdc.taco.learningcriteriaquery.entity.Section_;
import com.jdc.taco.learningcriteriaquery.entity.Student;
import com.jdc.taco.learningcriteriaquery.entity.StudentPk_;
import com.jdc.taco.learningcriteriaquery.entity.Student_;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.time.LocalDate;

public record StudentDto(
        String name,
        LocalDate registrationDate,
        LocalDate dateOfBirth,
        String sectionName
) {

    public static CriteriaQuery<StudentDto> select(CriteriaQuery<StudentDto> cq, Root<Student> root) {
        cq.multiselect(
                root.get(Student_.name),
                root.get(Student_.id).get(StudentPk_.registrationDate),
                root.get(Student_.dateOfBirth),
                root.get(Student_.section).get(Section_.name)
        );
        return cq;
    }
}

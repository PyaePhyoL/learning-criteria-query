package com.jdc.taco.learningcriteriaquery.repo;

import com.jdc.taco.learningcriteriaquery.dto.StudentDto;
import com.jdc.taco.learningcriteriaquery.entity.Section;
import com.jdc.taco.learningcriteriaquery.entity.Student;

import java.time.LocalDate;
import java.util.List;

public interface StudentRepo {

    List<StudentDto> findAll();

    List<StudentDto> findBySection(String section);

    List<StudentDto> findByDOBUnder(LocalDate dob);

    List<StudentDto> findByNameLike(String name);

    List<StudentDto> findBetweenRegister(LocalDate start, LocalDate end);

    List<StudentDto> findInSection(List<String> sections);
}

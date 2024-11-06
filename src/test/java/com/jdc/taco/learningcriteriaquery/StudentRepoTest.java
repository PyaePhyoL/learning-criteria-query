package com.jdc.taco.learningcriteriaquery;

import com.jdc.taco.learningcriteriaquery.repo.StudentRepoCriteria;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class StudentRepoTest {

    @Autowired
    private StudentRepoCriteria criteria;

    @Test
    public void findAllTest() {
        System.out.println(criteria.findAll());
    }

    @Test
    public void findBySectionTest() {
        System.out.println(criteria.findBySection("Bravura"));
    }

    @Test
    public void findByDOBUnderTest() {
        var date = LocalDate.of(2012, 1, 1);
        System.out.println(criteria.findByDOBUnder(date));
    }

    @Test
    public void findByNameLikeTest() {
        System.out.println(criteria.findByNameLike("s"));
    }

    @Test
    public void findBetweenRegisterTest() {
        var start = LocalDate.of(2018, 1, 1);
        var end = LocalDate.of(2020, 1, 1);
        System.out.println(criteria.findBetweenRegister(start, end));
    }

    @Test
    public void findInSectionTest() {
        var sections = List.of("Ambituoso", "Virtuoso");
        System.out.println(criteria.findInSection(sections));
    }
}

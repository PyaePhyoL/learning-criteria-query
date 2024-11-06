package com.jdc.taco.learningcriteriaquery.repo;

import com.jdc.taco.learningcriteriaquery.dto.StudentDto;
import com.jdc.taco.learningcriteriaquery.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public class StudentRepoCriteria implements StudentRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<StudentDto> findAll() {
        var cb = em.getCriteriaBuilder();
        var cq = cb.createQuery(StudentDto.class);
        var root = cq.from(Student.class);
        StudentDto.select(cq, root);
        return em.createQuery(cq).getResultList();
    }

    @Override
    public List<StudentDto> findBySection(String section) {
        var cb = em.getCriteriaBuilder();
        var cq = cb.createQuery(StudentDto.class);
        var root = cq.from(Student.class);
        StudentDto.select(cq, root);
        cq.where(cb.equal(root.get(Student_.section).get(Section_.name), section));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public List<StudentDto> findByDOBUnder(LocalDate dob) {
        var cb = em.getCriteriaBuilder();
        var cq = cb.createQuery(StudentDto.class);
        var root = cq.from(Student.class);
        StudentDto.select(cq, root);
        cq.where(cb.lessThan(root.get(Student_.dateOfBirth), dob));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public List<StudentDto> findByNameLike(String name) {
        var cb = em.getCriteriaBuilder();
        var cq = cb.createQuery(StudentDto.class);
        var root = cq.from(Student.class);
        StudentDto.select(cq, root);
        cq.where(cb.like(cb.lower(root.get(Student_.name)), name.toLowerCase().concat("%")));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public List<StudentDto> findBetweenRegister(LocalDate start, LocalDate end) {
        var cb = em.getCriteriaBuilder();
        var cq = cb.createQuery(StudentDto.class);
        var root = cq.from(Student.class);
        StudentDto.select(cq, root);
        cq.where(cb.between(root.get(Student_.id).get(StudentPk_.registrationDate), start, end));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public List<StudentDto> findInSection(List<String> sections) {
        var cb = em.getCriteriaBuilder();
        var cq = cb.createQuery(StudentDto.class);
        var root = cq.from(Student.class);
        StudentDto.select(cq, root);
        cq.where(root.get(Student_.section).get(Section_.name).in(sections));
        return em.createQuery(cq).getResultList();
    }
}

package com.springDB.myAppdb;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of StudentDAO interface using JPA EntityManager.
 */
@Repository
public class StudentDAOImpl implements StudentDAO {

    private final EntityManager entityManager;

    /**
     * Constructor-based dependency injection of EntityManager.
     */
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Saves a new student record in the database.
     */
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    /**
     * Finds a student by their ID.
     */
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    /**
     * Retrieves all students from the database whose email contains 'ada'.
     */
    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student ", Student.class);
        return theQuery.getResultList();
    }

    /**
     * Updates an existing student record.
     */
    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    /**
     * Deletes a student by their ID.
     */
    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent = entityManager.find(Student.class, id);
        if (theStudent != null) {
            entityManager.remove(theStudent);
        }
    }
}

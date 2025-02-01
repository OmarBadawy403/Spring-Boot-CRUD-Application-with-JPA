package com.springDB.myAppdb;

import java.util.List;

/**
 * Data Access Object (DAO) interface for Student entity.
 * Provides CRUD operations for Student objects.
 */
public interface StudentDAO {

    /**
     * Saves a new student to the database.
     * @param theStudent the student entity to be saved.
     */
    public void save(Student theStudent);

    /**
     * Finds a student by their ID.
     * @param id the ID of the student.
     * @return the Student object if found, otherwise null.
     */
    public Student findById(Integer id);

    /**
     * Retrieves all students from the database.
     * @return a list of all students.
     */
    public List<Student> findAll();

    /**
     * Updates an existing student in the database.
     * @param theStudent the student entity with updated details.
     */
    public void update(Student theStudent);

    /**
     * Deletes a student by their ID.
     * @param id the ID of the student to be deleted.
     */
    public void delete(Integer id);
}

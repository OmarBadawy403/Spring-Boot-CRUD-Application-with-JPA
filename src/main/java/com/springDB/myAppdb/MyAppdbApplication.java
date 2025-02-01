package com.springDB.myAppdb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MyAppdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAppdbApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// Uncomment the method you want to execute
			// createStudent(studentDAO);
			// readStudent(studentDAO);
			// getAllStudents(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
		};
	}

	/**
	 * Creates and saves multiple student records in the database.
	 */
	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating Students...");

		Student s1 = new Student("Omar", "Badawy", "omarbadawy@gmail.com");
		Student s2 = new Student("Ismail", "Badawy", "som3a@gmail.com");
		Student s3 = new Student("Ibrahim", "Badawy", "hima@gmail.com");
		Student s4 = new Student("Ahmed", "Badawy", "ahmedkamel@gmail.com");

		System.out.println("Saving Students...");
		studentDAO.save(s1);
		studentDAO.save(s2);
		studentDAO.save(s3);
		studentDAO.save(s4);

		System.out.println("Students saved successfully! IDs: " +
				s1.getId() + ", " + s2.getId() + ", " + s3.getId() + ", " + s4.getId());
	}

	/**
	 * Reads a student record from the database by ID.
	 */
	private void readStudent(StudentDAO studentDAO) {
		int studentId = 4; // Define the student ID to read
		System.out.println("Fetching student with ID: " + studentId);
		Student myStudent = studentDAO.findById(studentId);
		System.out.println("Student found: " + myStudent);
	}

	/**
	 * Retrieves and displays all students from the database.
	 */
	private void getAllStudents(StudentDAO studentDAO) {
		System.out.println("Fetching all students...");
		List<Student> students = studentDAO.findAll();
		for (Student s : students) {
			System.out.println(s);
		}
	}

	/**
	 * Updates the email of a specific student by ID.
	 */
	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 3; // Define the student ID to update
		System.out.println("Fetching student with ID: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		System.out.println("Updating student email...");
		myStudent.setEmail("example@gmail.com");
		studentDAO.update(myStudent);

		System.out.println("Student updated successfully: " + myStudent);
	}

	/**
	 * Deletes a student record from the database by ID.
	 */
	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 2; // Define the student ID to delete
		System.out.println("Deleting student with ID: " + studentId);
		studentDAO.delete(studentId);
		System.out.println("Student deleted successfully.");
	}
}

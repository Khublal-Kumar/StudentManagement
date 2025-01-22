package com.red.Student.Management.service;

import com.red.Student.Management.model.Student;

import java.util.List;

public interface StudentService {
    // Create or save a student
    Student saveStudent(Student student);

    // Get a student by ID
    Student getStudentById(Long id);

    // Get all students
    List<Student> getAllStudents();

    // Update a student's details
    Student updateStudent(Long id, Student student);

    // Delete a student by ID
    void deleteStudentById(Long id);

    // Find students by first name
    List<Student> findStudentsByFirstName(String firstName);

    // Find students by last name
    List<Student> findStudentsByLastName(String lastName);

    // Find students by city
    List<Student> findStudentsByCity(String city);

    // Find a student by email
    Student findStudentByEmail(String email);

    // Count students by state
    long countStudentsByState(String state);

    // Find students with GPA greater than a given value
    List<Student> findStudentsByGpaGreaterThan(Double gpa);

    // Check if a student exists by email
    boolean existsByEmail(String email);

    // Delete a student by email
    void deleteStudentByEmail(String email);
}

package com.red.Student.Management.repository;

import com.red.Student.Management.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {


    // Find students by first name
    List<Student> findByFirstName(String firstName);

    // Find students by last name
    List<Student> findByLastName(String lastName);

    // Find students by email
    Student findByEmail(String email);

    // Find students by city
    List<Student> findByCity(String city);

    // Custom query to find students with GPA greater than a certain value
    List<Student> findByGradePointAverageGreaterThan(Double gradePointAverage);

    // Custom query to find students by gender and city
    List<Student> findByGenderAndCity(String gender, String city);

    // Count students by state
    long countByState(String state);

    // Check if a student exists by email
    boolean existsByEmail(String email);

    // Delete a student by email
    void deleteByEmail(String email);
}

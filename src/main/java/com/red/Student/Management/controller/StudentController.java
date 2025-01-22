package com.red.Student.Management.controller;

import com.red.Student.Management.model.Student;
import com.red.Student.Management.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;  // Injecting the StudentService

    // Endpoint to create or update a student
    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);  // Save student
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);  // Return created status
    }

    // Endpoint to get a student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        try {
            Student student = studentService.getStudentById(id);  // Get student by ID
            return new ResponseEntity<>(student, HttpStatus.OK);  // Return OK status with student data
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);  // Return not found status if student doesn't exist
        }
    }

    // Endpoint to get all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();  // Get all students
        return new ResponseEntity<>(students, HttpStatus.OK);  // Return OK status with list of students
    }

    // Endpoint to update a student by ID
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        try {
            Student updatedStudent = studentService.updateStudent(id, student);  // Update student by ID
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);  // Return OK status with updated student
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);  // Return not found status if student doesn't exist
        }
    }

    // Endpoint to delete a student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id) {
        try {
            studentService.deleteStudentById(id);  // Delete student by ID
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // Return no content status after deletion
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Return not found status if student doesn't exist
        }
    }

    // Endpoint to find students by first name
    @GetMapping("/firstName/{firstName}")
    public ResponseEntity<List<Student>> findStudentsByFirstName(@PathVariable String firstName) {
        List<Student> students = studentService.findStudentsByFirstName(firstName);  // Find students by first name
        return new ResponseEntity<>(students, HttpStatus.OK);  // Return OK status with list of students
    }

    // Endpoint to find students by last name
    @GetMapping("/lastName/{lastName}")
    public ResponseEntity<List<Student>> findStudentsByLastName(@PathVariable String lastName) {
        List<Student> students = studentService.findStudentsByLastName(lastName);  // Find students by last name
        return new ResponseEntity<>(students, HttpStatus.OK);  // Return OK status with list of students
    }

    // Endpoint to find students by city
    @GetMapping("/city/{city}")
    public ResponseEntity<List<Student>> findStudentsByCity(@PathVariable String city) {
        List<Student> students = studentService.findStudentsByCity(city);  // Find students by city
        return new ResponseEntity<>(students, HttpStatus.OK);  // Return OK status with list of students
    }

    // Endpoint to find a student by email
    @GetMapping("/email/{email}")
    public ResponseEntity<Student> findStudentByEmail(@PathVariable String email) {
        Student student = studentService.findStudentByEmail(email);  // Find student by email
        return student != null ?
                new ResponseEntity<>(student, HttpStatus.OK) :  // Return OK status if found
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND);  // Return not found status if not found
    }

    // Endpoint to get student count by state
    @GetMapping("/state/{state}/count")
    public ResponseEntity<Long> countStudentsByState(@PathVariable String state) {
        long count = studentService.countStudentsByState(state);  // Count students by state
        return new ResponseEntity<>(count, HttpStatus.OK);  // Return OK status with count
    }

    // Endpoint to find students with GPA greater than a value
    @GetMapping("/gpa/{gpa}")
    public ResponseEntity<List<Student>> findStudentsByGpaGreaterThan(@PathVariable Double gpa) {
        List<Student> students = studentService.findStudentsByGpaGreaterThan(gpa);  // Find students by GPA
        return new ResponseEntity<>(students, HttpStatus.OK);  // Return OK status with list of students
    }

    // Endpoint to check if a student exists by email
    @GetMapping("/existsByEmail/{email}")
    public ResponseEntity<Boolean> existsByEmail(@PathVariable String email) {
        boolean exists = studentService.existsByEmail(email);  // Check if student exists by email
        return new ResponseEntity<>(exists, HttpStatus.OK);  // Return OK status with boolean result
    }

    // Endpoint to delete a student by email
    @DeleteMapping("/email/{email}")
    public ResponseEntity<Void> deleteStudentByEmail(@PathVariable String email) {
        try {
            studentService.deleteStudentByEmail(email);  // Delete student by email
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // Return no content status after deletion
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Return not found status if student doesn't exist
        }
    }
}

package com.red.Student.Management.service;


import com.red.Student.Management.model.Student;
import com.red.Student.Management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentRepository studentRepository;  // Injecting the repository for database access

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);  // Save or update the student
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);  // Find student by ID
        return student.orElseThrow(() -> new RuntimeException("Student not found with id: " + id));  // If not found, throw exception
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();  // Retrieve all students
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        // Check if the student exists by ID
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found with id: " + id);
        }

        student.setId(id);  // Set the ID for the student object to update
        return studentRepository.save(student);  // Save the updated student
    }

    @Override
    public void deleteStudentById(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);  // Delete the student by ID
    }

    @Override
    public List<Student> findStudentsByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);  // Find students by first name
    }

    @Override
    public List<Student> findStudentsByLastName(String lastName) {
        return studentRepository.findByLastName(lastName);  // Find students by last name
    }

    @Override
    public List<Student> findStudentsByCity(String city) {
        return studentRepository.findByCity(city);  // Find students by city
    }

    @Override
    public Student findStudentByEmail(String email) {
        return studentRepository.findByEmail(email);  // Find student by email
    }

    @Override
    public long countStudentsByState(String state) {
        return studentRepository.countByState(state);  // Count students by state
    }

    @Override
    public List<Student> findStudentsByGpaGreaterThan(Double gpa) {
        return studentRepository.findByGradePointAverageGreaterThan(gpa); // Find students with GPA greater than a value
    }

    @Override
    public boolean existsByEmail(String email) {
        return studentRepository.existsByEmail(email);  // Check if a student exists by email
    }

    @Override
    public void deleteStudentByEmail(String email) {
        Student student = studentRepository.findByEmail(email);
        if (student != null) {
            studentRepository.deleteByEmail(email);  // Delete the student by email
        } else {
            throw new RuntimeException("Student not found with email: " + email);
        }
    }
}

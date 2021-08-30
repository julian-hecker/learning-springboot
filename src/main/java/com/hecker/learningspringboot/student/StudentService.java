package com.hecker.learningspringboot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired // Autowired is used for dependency injection
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("Email is already in use");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean idExists = studentRepository.existsById((id));
        if (!idExists) throw new IllegalStateException("Student with id " + id + " does not exist!");
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent (Long id, String name, String email) {

    }
}

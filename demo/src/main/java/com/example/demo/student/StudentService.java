package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//business logic , management student class
@Service
public class StudentService {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> optionalStudent = studentRepository.findStudentByEmail(student.getEmail());
        if (optionalStudent.isPresent()){
            throw new IllegalStateException("Email Taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("student with id "+ studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentID, String fullName, String email) {
        Student student = studentRepository.findById(studentID).orElseThrow(() -> new IllegalStateException(
                "student with id " + studentID + " does not exists"
        ));

        if(fullName != null && fullName.length() > 0 && !Objects.equals(fullName, student.getFullName())){
            student.setFullName(fullName);
        }
        if(email != null && email.length() > 0 && !Objects.equals(email, student.getEmail())){
            Optional<Student> optionalStudent = studentRepository.findStudentByEmail(email);
            if (optionalStudent.isPresent()){
                throw new IllegalStateException("Email is Taken");
            }
            student.setEmail(email);
        }
    }
}

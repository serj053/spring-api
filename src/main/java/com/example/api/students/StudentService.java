package com.example.api.students;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentrepository;

    public StudentService(StudentRepository studentrepository) {
        this.studentrepository = studentrepository;
    }

    public List<Student> list() {
        return studentrepository.findAll();
    }

    public void add(Student student) {
        studentrepository.save(student);
    }
}

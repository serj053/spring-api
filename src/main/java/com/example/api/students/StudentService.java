package com.example.api.students;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

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
        if(studentrepository.findStudentByEmail(student.getEmail()).isPresent()){
            throw new IllegalStateException("Email is busy");
        }
        studentrepository.save(student);
    }

    public void delete(Long studentId) {
        studentrepository.deleteById(studentId);
    }

    public void update(Student student) {
        Optional<Student> row = studentrepository.findById(student.getId());
        if (row.isPresent()) {
            Student item = row.get();
            if (!student.getName().isEmpty()) {
                item.setName(student.getName());
            }
            if (student.getDob() != null) {
                item.setDob(student.getDob());
            }
            studentrepository.save(item);
        }
    }
}

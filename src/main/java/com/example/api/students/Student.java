package com.example.api.students;

import java.time.LocalDate;

public class Student {
    private Long id;
    private String name;
    private LocalDate dob;

    public Student(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

}

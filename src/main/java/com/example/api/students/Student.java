package com.example.api.students;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;
    private String name;
    @Column(unique=true)//при создании таблицы к этому полю будет добавлен уникальный ключ
    private String email;

    private LocalDate dob;

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    //пустой конструктор заполняется данными из таблицы
    public Student() {
    }

    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                '}';
    }
}

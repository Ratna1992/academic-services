package com.academics.service;

import com.academics.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> createStudents(List<Student> list);

    boolean deleteStudents(List<Student> list);

    void updateStudent(Student student);

    List<Student> retrieveStudents();

    Student retrieveStudent(Long id);
}

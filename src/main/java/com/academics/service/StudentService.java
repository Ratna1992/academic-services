package com.academics.service;

import com.academics.entity.Student;

import java.util.List;

public interface StudentService {

    boolean createStudents(List<Student> list);

    boolean deleteStudents(List<Student> list);

    boolean updateStudents(List<Student> list);

    List<Student> retriveStudents();

    Student retrieveStudent(Long id);
}

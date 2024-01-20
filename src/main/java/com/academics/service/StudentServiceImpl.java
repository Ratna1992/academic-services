package com.academics.service;

import com.academics.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Override
    public boolean createStudents(List<Student> list) {
        return false;
    }

    @Override
    public boolean deleteStudents(List<Student> list) {
        return false;
    }

    @Override
    public boolean updateStudents(List<Student> list) {
        return false;
    }

    @Override
    public List<Student> retriveStudents() {
        return null;
    }

    @Override
    public Student retrieveStudent(Long id) {
        return null;
    }
}

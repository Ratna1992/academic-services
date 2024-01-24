package com.academics.service;

import com.academics.entity.Student;
import com.academics.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public List<Student> createStudents(List<Student> list) {
        List<Student> students = repository.saveAll(list);
        return students;
    }

    @Override
    public boolean deleteStudents(List<Student> list) {
        try {
            repository.deleteAllByIdInBatch(list.stream().map(stu -> stu.getSid()).collect(Collectors.toList()));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void updateStudent(Student modifyingStudent) {
        Student existingStudent = repository.findById(modifyingStudent.getSid()).get();

        if (modifyingStudent.getEmail() != null) {
            existingStudent.setEmail(modifyingStudent.getEmail());
        }
        if (modifyingStudent.getPassword() != null) {
            existingStudent.setPassword(modifyingStudent.getPassword());
        }
        if (modifyingStudent.getFname() != null) {
            existingStudent.setFname(modifyingStudent.getFname());
        }
        if (modifyingStudent.getLname() != null) {
            existingStudent.setLname(modifyingStudent.getLname());
        }
        if (modifyingStudent.getMname() != null) {
            existingStudent.setMname(modifyingStudent.getMname());
        }
        if (modifyingStudent.getPhone() != null) {
            existingStudent.setPhone(modifyingStudent.getPhone());
        }
        if (modifyingStudent.getMobile() != null) {
            existingStudent.setMobile(modifyingStudent.getMobile());
        }
        if (modifyingStudent.getDob() != null) {
            existingStudent.setDob(modifyingStudent.getDob());
        }
        if (modifyingStudent.getStatus() != null) {
            existingStudent.setStatus(modifyingStudent.getStatus());
        }
        if (modifyingStudent.getDoj() != null) {
            existingStudent.setDoj(modifyingStudent.getDoj());
        }
         repository.updateStudent(existingStudent.getEmail(), existingStudent.getPassword(), existingStudent.getFname(), existingStudent.getLname(), existingStudent.getMname(), existingStudent.getPhone(), existingStudent.getMobile(), existingStudent.getDob(), existingStudent.getStatus(), existingStudent.getDoj(), existingStudent.getSid());
    }

    @Override
    public List<Student> retrieveStudents() {
        return repository.findAll().stream().filter(s -> s.getStatus().equalsIgnoreCase("ACTIVE")).collect(Collectors.toList());
    }

    @Override
    public Student retrieveStudent(Long id) {
        Student student = repository.findById(id).get();
        return student.getStatus().equalsIgnoreCase("Active") ? student : null;
    }
}

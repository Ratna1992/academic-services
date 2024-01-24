package com.academics.repository;

import com.academics.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Transactional
    @Modifying
    @Query("update Student s SET s.email=?1,s.password=?2,s.fname=?3,s.lname=?4,s.mname=?5,s.phone=?6,s.mobile=?7,s.dob=?8,s.status=?9,s.doj=?10 where s.sid=?11")
    void updateStudent(String email, String password, String fname, String lname, String mname, String phone, String mobile, Date dob, String status, Date doj, Long sid);
}

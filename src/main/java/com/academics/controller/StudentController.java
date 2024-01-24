package com.academics.controller;

import com.academics.beans.AcademicsResponse;
import com.academics.entity.Student;
import com.academics.exceptions.EmptyRequestException;
import com.academics.service.StudentService;
import com.academics.utilities.ErrorCodes;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    ResponseEntity<AcademicsResponse> createStudents(@RequestBody List<Student> list, HttpServletRequest request) throws EmptyRequestException {
        if (list.isEmpty()) {
            throw new EmptyRequestException(ErrorCodes.EMPTY_REQUEST);
        }
        request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String remoteAddress = request.getRemoteAddr();
        list.forEach(stud -> {
            stud.setLastLoginDate(Timestamp.from(Instant.now()));
            stud.setLastLoginIp(remoteAddress);
        });
        List<String> stringList = studentService.createStudents(list).stream().map(student -> student.getSid() + " " + student.getFname()).collect(Collectors.toList());
        AcademicsResponse academicsResponse = new AcademicsResponse();
        academicsResponse.setError(null);
        Map<String, List<String>> data = new HashMap<>();
        data.put(ErrorCodes.CREATED, stringList);
        academicsResponse.setData(data);
        academicsResponse.setStatus(ErrorCodes.SUCCESS);
        return new ResponseEntity<>(academicsResponse, HttpStatus.OK);
    }

    @DeleteMapping
    ResponseEntity<AcademicsResponse> deleteStudents(@RequestBody List<Student> list) {
//        list.forEach(stud -> {
//            stud.setStatus("InActive");
//        });
        studentService.deleteStudents(list);
        AcademicsResponse academicsResponse = new AcademicsResponse();
        academicsResponse.setError(null);
        academicsResponse.setData(ErrorCodes.DELETED);
        academicsResponse.setStatus(ErrorCodes.SUCCESS);
        return new ResponseEntity<>(academicsResponse, HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<AcademicsResponse> updateStudent(@RequestBody Student modifyingStudent) {
        studentService.updateStudent(modifyingStudent);
        AcademicsResponse academicsResponse = new AcademicsResponse();
        academicsResponse.setError(null);
        academicsResponse.setData(ErrorCodes.UPDATED);
        academicsResponse.setStatus(ErrorCodes.SUCCESS);
        return new ResponseEntity<>(academicsResponse, HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<AcademicsResponse> retrieveStudents() {
        AcademicsResponse academicsResponse = new AcademicsResponse();
        academicsResponse.setError(null);
        academicsResponse.setData(studentService.retrieveStudents());
        academicsResponse.setStatus(ErrorCodes.SUCCESS);
        return new ResponseEntity<>(academicsResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<AcademicsResponse> retrieveStudent(@PathVariable Long id) {
        AcademicsResponse academicsResponse = new AcademicsResponse();
        academicsResponse.setError(null);
        Student student = studentService.retrieveStudent(id);
        academicsResponse.setData(student == null ? ErrorCodes.IN_ACTIVE : student);
        academicsResponse.setStatus(ErrorCodes.SUCCESS);
        return new ResponseEntity<>(academicsResponse, HttpStatus.OK);
    }
}

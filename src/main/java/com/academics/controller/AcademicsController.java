package com.academics.controller;

import com.academics.beans.AcademicsResponse;
import com.academics.service.AcademicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AcademicsController {

    @Autowired
    private AcademicsService academicsService;
    @GetMapping("/status")
    public AcademicsResponse getStatus(){
    return academicsService.getStatus();
    }
}

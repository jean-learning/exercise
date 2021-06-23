package com.org.jean.controller;

import com.org.jean.mysql.service.StudentInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.org.jean.jpa.service.StudentServiceImpl;

@RestController
public class ApplicationController {

    @GetMapping("/hello")
    public String message(){
        return "hello";
    }
}

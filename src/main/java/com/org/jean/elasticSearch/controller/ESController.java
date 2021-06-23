package com.org.jean.elasticSearch.controller;

import com.org.jean.elasticSearch.service.ESService;
import com.org.jean.mysql.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ESController {

    @Autowired
    ESService esService;

//    @RequestMapping(value = "/insertdata", method = RequestMethod.POST)
    @PostMapping("/insertdata")
    public Student insertData(@RequestBody Student student) {
        return esService.addStudent(student);
    }

    @GetMapping(value = "/getdata/{id}")
    public Map<String, Object> getStudentById(@PathVariable ("id") String id){
        return esService.getStudentById(id);
    }
}

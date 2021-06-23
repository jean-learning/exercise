package com.org.jean.elasticSearch.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.org.jean.elasticSearch.service.ESService;
import com.org.jean.mysql.model.Student;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.net.URI;

import static org.junit.Assert.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ESControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Mock
    ESService esService;

    @InjectMocks
    ESController esController;

    @org.junit.Before
    public void setUp() throws Exception {
        esController = new ESController();
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(esController).build();
    }

    @org.junit.Test
    public void insertData() throws Exception {
        Student student = new Student();
        student.setId("1");
        student.setName("jean");
        String s = new ObjectMapper().writeValueAsString(student);
        mockMvc.perform(MockMvcRequestBuilders.post("/insertdata")

                .contentType(MediaType.APPLICATION_JSON)
                .content(s)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

    @org.junit.Test
    public void getStudentById() {
    }
}
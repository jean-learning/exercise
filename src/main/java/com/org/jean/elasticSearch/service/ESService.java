package com.org.jean.elasticSearch.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.jean.mysql.model.Student;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Service
public class ESService {

    @Autowired
    RestHighLevelClient client;

    public Student addStudent(Student student)  {
        student.setId(UUID.randomUUID().toString());
        Map<String, Object> dataMap = new ObjectMapper().convertValue(student, Map.class);
        IndexRequest indexRequest = new IndexRequest("studentdata", "students", student.getId()).source(dataMap);
        try {
            client.index(indexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return student;
    }

    public Map<String, Object> getStudentById(String id){
        GetRequest getRequest = new GetRequest("studentdata", "students", id);
        GetResponse getResponse = null;

        try {
            getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
        return sourceAsMap;

    }
}

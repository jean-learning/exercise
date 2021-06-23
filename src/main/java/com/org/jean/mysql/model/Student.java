package com.org.jean.mysql.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="STUDENTS")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student {
    @Id
    private String id;
    private String name;
    private int age;


}

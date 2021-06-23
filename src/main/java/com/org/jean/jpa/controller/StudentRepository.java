package com.org.jean.jpa.controller;

import com.org.jean.mysql.model.Student;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

//@RepositoryRestResource(path = "students")
@Profile("db")
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findById(@Param("id") String id, Pageable pageable);

    List<Student> findByName(@Param("name") String name, Pageable pageable);

    List<Student> findByName(@Param("name") String name);
}

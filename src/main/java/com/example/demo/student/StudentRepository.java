package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}

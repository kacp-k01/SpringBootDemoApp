package com.example.demo.config;

import com.example.demo.student.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner (StudentRepository studentRepository){
        return args -> {
          Student Mariam = new Student("Mariam","mariam.jamal@gmail.com",
                  LocalDate.of(2000, Month.JANUARY,5));
            Student John = new Student("John","Kajto.jamal@gmail.com",
                    LocalDate.of(2000, Month.JANUARY,5));

            studentRepository.saveAll(List.of(Mariam,John));
        };
    }
}


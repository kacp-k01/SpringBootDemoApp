package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.Calendar.JANUARY;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner (StudentRepository studentRepository){
        return args -> {
          Student Mariam = new Student("Mariam","mariam.jamal@gmail.com",
                  LocalDate.of(2000, Month.JANUARY,5));
            Student Kajto = new Student("Kajto","Kajto.jamal@gmail.com",
                    LocalDate.of(2000, Month.JANUARY,5));

            studentRepository.saveAll(List.of(Mariam,Kajto));
        };
    }

}


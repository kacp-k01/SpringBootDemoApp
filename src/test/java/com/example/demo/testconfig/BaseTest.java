package com.example.demo.testconfig;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import com.example.demo.student.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BaseTest {
    @InjectMocks
    protected StudentService studentService;
    @Mock
    protected StudentRepository studentRepository;

    @BeforeEach
    void setUpData(){
        Student testStudent = new Student("Mariam","mariam@gmail.com",
                LocalDate.of(2000, Month.JANUARY,5));
        when(studentRepository.findAll()).thenReturn(List.of(testStudent));
        studentService.addNewStudent(testStudent);
        studentRepository.save(testStudent);
    }
}
package com.example.demo.testconfig;

import com.example.demo.controller.StudentController;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import com.example.demo.student.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BaseTest {
    @Mock
    protected StudentService studentService;
    @Mock
    protected StudentRepository studentRepository;
    protected MockMvc mockMvc;
    private StudentController studentController;

    protected Student testStudent = new Student("Mariam", "mariam@gmail.com",
            LocalDate.of(2000, Month.JANUARY, 5));

    @BeforeEach
    void setUpData() {
        studentController = new StudentController(studentService);
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
    }
}
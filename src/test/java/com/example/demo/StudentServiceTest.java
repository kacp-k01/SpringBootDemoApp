package com.example.demo;

import com.example.demo.student.StudentRepository;
import com.example.demo.student.StudentService;
import com.example.demo.student.Student;
import com.example.demo.testconfig.TestRepositoryConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

//@SpringBootTest(classes = {TestRepositoryConfig.class})


//    @Autowired
//    TestRepositoryConfig testRepositoryConfig = new TestRepositoryConfig();
////    @Autowired
////    private StudentService studentService;
////    @Autowired
////    private StudentRepository studentRepository;
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @InjectMocks  // Use @InjectMocks to inject the dependencies into the tested class
    StudentService studentService;
    @Mock
    StudentRepository studentRepository;

    @Test
    public void testGetStudents() {
        List<Student> students = new ArrayList<>();
        when(studentRepository.findAll()).thenReturn(students);
        List<Student> result = studentService.getStudents();
        verify(studentRepository, times(1)).findAll();
        assertEquals(students, result);
    }
}

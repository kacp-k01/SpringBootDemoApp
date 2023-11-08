package com.example.demo.testconfig;
import com.example.demo.student.StudentRepository;
import com.example.demo.student.StudentService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BaseTest {
    @InjectMocks
    protected StudentService studentService;

    @Mock
    protected StudentRepository studentRepository;

}
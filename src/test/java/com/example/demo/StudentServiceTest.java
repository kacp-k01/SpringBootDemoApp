package com.example.demo;

import com.example.demo.student.Student;
import com.example.demo.testconfig.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest extends BaseTest {

    @Test
    public void testGetStudents() {
        List<Student> students = new ArrayList<>();
        when(studentRepository.findAll()).thenReturn(students);
        List<Student> result = studentService.getStudents();
        verify(studentRepository, times(1)).findAll();
        assertEquals(students, result);
    }
}

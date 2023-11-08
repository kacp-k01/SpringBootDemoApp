package com.example.demo;

import com.example.demo.service.StudentService;
import com.example.demo.student.Student;
import com.example.demo.testconfig.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest extends BaseTest {

    @InjectMocks
    protected StudentService studentServiceTestInstance;

    @Test
    public void testGetStudents() {
        when(studentRepository.findAll()).thenReturn(List.of(testStudent));
        List<Student> result = studentServiceTestInstance.getStudents();
        verify(studentRepository, times(1)).findAll();
        assertEquals(1, result.size());
        Student expected =  new Student("Mariam","mariam@gmail.com",
                LocalDate.of(2000, Month.JANUARY,5));
        assertThat(result.get(0))
                .usingRecursiveComparison()
                .ignoringFields("systemCreationTime")
                .isEqualTo(expected);
    }

    @Test
    public void testNewStudent() {
        Student newStudent =  new Student("John","john@gmail.com",
                LocalDate.of(1998, Month.FEBRUARY,1));
        when(studentRepository.findAll()).thenReturn(List.of(newStudent));
        studentServiceTestInstance.addNewStudent(newStudent);
        List<Student> result = studentServiceTestInstance.getStudents();
        verify(studentRepository, times(1)).save(newStudent);
        assertEquals(1, result.size());
        assertThat(result.get(0))
                .usingRecursiveComparison()
                .ignoringFields("systemCreationTime")
                .isEqualTo(newStudent);
    }


}

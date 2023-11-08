package com.example.demo;

import com.example.demo.controller.StudentController;
import com.example.demo.student.Student;
import com.example.demo.testconfig.BaseTest;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentControllerTest extends BaseTest {

    @Test
    public void testGetStudentsWithData() throws Exception {
        Student testStudent = new Student("Mariam", "mariam@gmail.com", LocalDate.of(2000, Month.JANUARY, 5));
        when(studentService.getStudents()).thenReturn(List.of(testStudent));

        mockMvc.perform(get("/api/v1/student/allStudents"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("Mariam"))
                .andExpect(jsonPath("$[0].email").value("mariam@gmail.com"))
                .andExpect(jsonPath("$[0].dob[0]").value(2000))
                .andExpect(jsonPath("$[0].dob[1]").value(1))
                .andExpect(jsonPath("$[0].dob[2]").value(5));
    }

    @Test
    public void testGetStudentsWithNoData() throws Exception {
        when(studentService.getStudents()).thenReturn(List.of());
        try {
            mockMvc.perform(get("/api/v1/student/allStudents"))
                    .andExpect(status().isInternalServerError());
        }
        catch (Exception e) {
                assertTrue(e instanceof ServletException);
                String exceptionMessage = e.getMessage();
                assertEquals("Request processing failed: com.example.demo.exception.ApiRequestException: No students to Show", exceptionMessage);
        }
    }

    @Test
    public void testRegisterNewStudent() throws Exception {
        Student newStudent = new Student("John", "john@example.com", LocalDate.of(2002, Month.MARCH, 10));

        mockMvc.perform(post("/api/v1/student")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"John\",\"email\":\"john@example.com\",\"dob\":\"2002-03-10\"}"))
                .andExpect(status().isOk());

        Mockito.verify(studentService).addNewStudent(newStudent);
    }
}
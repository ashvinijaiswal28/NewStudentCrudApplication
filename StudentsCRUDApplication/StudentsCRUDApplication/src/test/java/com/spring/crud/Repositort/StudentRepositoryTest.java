package com.spring.crud.Repositort;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.crud.Entity.Student;
import com.spring.crud.Repository.StudentRepository;
import com.spring.crud.Service.StudentService;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentRepositoryTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void testFindByFirstName() {
        String firstName = "John";
        List<Student> students = List.of(new Student(), new Student());
        when(studentRepository.findByFirstName(firstName)).thenReturn(students);

        List<Student> result = studentRepository.findByFirstName(firstName);
        assertEquals(2, result.size());
    }

    @Test
    public void testGetStudentInfo() {
        List<Object[]> studentInfoList = List.of(new Object[]{}, new Object[]{});
        when(studentRepository.getStudentInfo()).thenReturn(studentInfoList);

        List<Object[]> result = studentRepository.getStudentInfo();
        assertEquals(2, result.size());
    }
}


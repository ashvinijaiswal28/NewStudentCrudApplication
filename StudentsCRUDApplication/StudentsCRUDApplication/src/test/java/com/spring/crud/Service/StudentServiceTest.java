
 package com.spring.crud.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.spring.crud.Entity.Student;
import com.spring.crud.Repository.StudentRepository;
import com.spring.crud.Wrapper.StudentDeptCourse;

import java.util.Optional;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPostStudent() {
        StudentDeptCourse studentWrapper = new StudentDeptCourse();
        when(studentRepository.save(any(Student.class))).thenReturn(new Student());

        String result = studentService.postStudent(studentWrapper);
        assertEquals("{\"status\":\"Student Added Successfully.\"}", result);
    }

    @Test
    public void testGetAllStudent() {
        List<Student> students = List.of(new Student(), new Student());
        when(studentRepository.findAll()).thenReturn(students);

        List<Student> result = studentService.getAllStudent();
        assertEquals(2, result.size());
    }

    @Test
    public void testDeleteStudent() {
        Long id = 1L;
        studentService.deleteStudent(id);
        verify(studentRepository, times(1)).deleteById(id);
    }

    @Test
    public void testGetStudentById_Exists() {
        Long id = 1L;
        Student student = new Student();
        when(studentRepository.findById(id)).thenReturn(Optional.of(student));

        Student result = studentService.getStudentById(id);
        assertEquals(student, result);
    }

    @Test
    public void testGetStudentById_NotExists() {
        Long id = 1L;
        when(studentRepository.findById(id)).thenReturn(Optional.empty());

        Student result = studentService.getStudentById(id);
        assertEquals(null, result);
    }

  


  

    @Test
    public void testGetStudentsByFirstName() {
        String firstName = "John";
        List<Student> students = List.of(new Student(), new Student());
        when(studentRepository.findByFirstName(firstName)).thenReturn(students);

        List<Student> result = studentService.getStudentsByFirstName(firstName);
        assertEquals(2, result.size());
    }
}
 
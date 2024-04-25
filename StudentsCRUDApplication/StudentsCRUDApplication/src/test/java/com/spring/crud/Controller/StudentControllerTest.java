package com.spring.crud.Controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.crud.Entity.Student;
import com.spring.crud.Service.StudentService;
import com.spring.crud.Wrapper.StudentDeptCourse;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

	@Mock
	private StudentService studentService;

	@InjectMocks
	private StudentController studentController;

	private MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
	}

	@Test
	public void testGetAllStudents() throws Exception {
		List<Student> students = new ArrayList<>();

		when(studentService.getAllStudent()).thenReturn(students);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/getStudentList").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void testDeleteStudent() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/deleteStudent/1")).andExpect(status().isOk());
	}

	@Test
	public void testGetStudentById() throws Exception {
		Student student = new Student();
		when(studentService.getStudentById(1L)).thenReturn(student);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/getStudentByID/1")).andExpect(status().isOk());
	}

	@Test
	public void testGetStudentInfo() throws Exception {
		List<Object[]> studentInfoList = new ArrayList<>();

		when(studentService.getStudentInfo()).thenReturn(studentInfoList);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/getStudentInfo/1")).andExpect(status().isOk());
	}

	@Test
	public void testGetStudentsByFirstName() throws Exception {
		List<Student> students = new ArrayList<>();
		when(studentService.getStudentsByFirstName("John")).thenReturn(students);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/students?first_name=John")).andExpect(status().isOk());
	}

	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

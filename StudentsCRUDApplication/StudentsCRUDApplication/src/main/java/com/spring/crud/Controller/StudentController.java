package com.spring.crud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.Entity.Student;
import com.spring.crud.Service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StudentController {
	@Autowired
	private StudentService studentservice;

	@PostMapping("/students")
	public Student postStudent(@RequestBody Student student) {
		return studentservice.postStudent(student);
	}

	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return studentservice.getAllStudent();
	}

	@DeleteMapping("/students/{id}")
	public void deleteStudents(@PathVariable Long id) {
		studentservice.deleteStudent(id);
		// System.out .print("deleted successfully"+id);
	}

	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentsById(@PathVariable Long id) { 
	    Student student = studentservice.getStudentById(id); 
	    if (student == null) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.ok(student); 
	    }
	}
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudents(@PathVariable Long id,@RequestBody Student student){
		Student updatest=studentservice.updateStudent(id, student);
		if (updatest == null) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	    } else {
	        return ResponseEntity.ok(updatest); 
	    }
	}


	}



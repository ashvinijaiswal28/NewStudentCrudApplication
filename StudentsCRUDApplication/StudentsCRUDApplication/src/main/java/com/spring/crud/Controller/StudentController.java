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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.Entity.Student;
import com.spring.crud.Service.StudentService;
import com.spring.crud.Wrapper.StudentDeptCourse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StudentController {
	@Autowired
	private StudentService studentservice;
	
	

	@PostMapping("/create")
	public String postStudent(@RequestBody StudentDeptCourse student) {
		return studentservice.postStudent(student);
	}

	@GetMapping("/getStudentList")
	public List<Student> getAllStudents() {
		return studentservice.getAllStudent();
	}

	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudents(@PathVariable Long id) {
		studentservice.deleteStudent(id);
	}

	@GetMapping("/getStudentByID/{id}")
	public ResponseEntity<Student> getStudentsById(@PathVariable Long id) {
		Student student = studentservice.getStudentById(id);
		if (student == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(student);
		}
	}

	@PutMapping("/updateStudentByID/{id}")
	public ResponseEntity<Student> updateStudents(@PathVariable Long id, @RequestBody StudentDeptCourse student) {
		Student updatest = studentservice.updateStudent(id, student);
		if (updatest == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} else {
			return ResponseEntity.ok(updatest);
		}
	}
	
	 @GetMapping("/getStudentInfo/{id}")
	 public List<Object[]> getStudentInfo() {
	        return studentservice.getStudentInfo();
	    }
	 
	 @GetMapping("/students")
	 public List<Student> getStudentsByFirstName(@RequestParam String first_name) {
	     return studentservice.getStudentsByFirstName(first_name);
	 }


}

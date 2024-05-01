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

import com.spring.crud.Entity.Course;
import com.spring.crud.Entity.Department;
import com.spring.crud.Entity.Student;
import com.spring.crud.Repository.CourseRepository;
import com.spring.crud.Repository.DepartmentRepository;
import com.spring.crud.Service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StudentController {
	
	@Autowired
	private StudentService studentservice;
	
	@Autowired
	private DepartmentRepository  departmentRepository;
	
	@Autowired
	private CourseRepository  courseRepository;

	@PostMapping("/create")
	public String postStudent(@RequestBody Student student) {
		return studentservice.postStudent(student);
	}

	@GetMapping("/getStudentList")
	public List<Student> getAllStudents() {
		return studentservice.getAllStudentDepartmentCourses();
	}

	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudents(@PathVariable Long id) {
		studentservice.deleteStudent(id);
	}

	@GetMapping("/getStudentByID/{id}")
	public Student getStudentsById(@PathVariable Long id) {
		return studentservice.getStudentDataById(id);
	}

	@PutMapping("/updateStudentByID/{id}")
	public ResponseEntity<Student> updateStudents(@PathVariable Long id, @RequestBody Student student) {
		Student updatest = studentservice.updateStudent(id, student);
		if (updatest == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} else {
			return ResponseEntity.ok(updatest);
		}
	}
	
	 @GetMapping("/searchStudentsByFirstName")
	 public List<Student> getStudentsByFirstName(@RequestParam String firstName) {
	       return studentservice.getStudentsByFirstName(firstName);
	     }	 
	 
	 @GetMapping("/searchStudentsNDepartment")
	 public List<Student> searchStudentsNDepartment(@RequestParam String firstName,@RequestParam String department) {
	       return studentservice.searchStudentsNDepartment(firstName,department);
	     }	
	 

	 @GetMapping("/getDepartmentMasterData")
		   public List<Department> getDepartmentMasterData() {
		        return departmentRepository.getDepartmentMasterData();
		    }
	 
	 @GetMapping("/getCoursetMasterData")
	   public List<Course> getCoursetMasterData() {
	        return courseRepository.getCoursetMasterData();
	    }
}

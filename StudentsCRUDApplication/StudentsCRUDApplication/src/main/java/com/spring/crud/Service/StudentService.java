package com.spring.crud.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.Entity.Student;
import com.spring.crud.Repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentrepository;
	
	@Transactional
	public String postStudent(Student studen) {
		setStudentFields(studen);
		return "{\"status\":\"Student Added Successfully.\"}";
	}

	private void setStudentFields(Student student) {
		studentrepository.save(student);
	}

	public List<Student> getAllStudent() {
		return studentrepository.findAll();
	}

	public void deleteStudent(Long id) {
		studentrepository.deleteById(id);
	}

	public Student getStudentById(Long id) {
		return studentrepository.findById(id).orElse(null);
	}

	public Student updateStudent(Long id, Student student) {
		Optional<Student> optionalStudent = studentrepository.findById(id);
		if (optionalStudent.isPresent()) {
			Student existingStudent = optionalStudent.get();
			existingStudent.setEmail(student.getEmail());
			existingStudent.setFirstName(student.getFirstName());
			existingStudent.setLastName(student.getLastName());
			existingStudent.setContact(student.getContact());
			existingStudent.setAge(student.getAge());
			existingStudent.setDepartment(student.getDepartment());
			existingStudent.setCourse(student.getCourse());
			return studentrepository.save(existingStudent);
		}
		return null;
	}

	  public List<String> getAllFirstNames() {
	        List<Student> students = studentrepository.findAll();
	        List<String> firstNames = students.stream()
	                                        .map(Student::getFirstName)
	                                        .collect(Collectors.toList());
	        return firstNames;
	    }

	public List<Student> getAllStudentDepartmentCourses() {
		return studentrepository.findAll();
	}

	public Student getStudentDataById(Long id) {
		Student student = studentrepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
		return student;
	}
	 	  
	public List<Student> getStudentsByFirstName(String firstName) {
		return  studentrepository.search(firstName);
		}

	public List<Student> searchStudentsNDepartment(String firstName, String department) {
		return  studentrepository.searchStudentsNDepartment(firstName,department);
	}

	
}

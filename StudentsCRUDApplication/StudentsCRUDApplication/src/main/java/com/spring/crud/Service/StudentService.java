package com.spring.crud.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.Entity.Student;
import com.spring.crud.Repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
	@Autowired
	private StudentRepository studentrepository;

	public Student postStudent(Student student) {
		return studentrepository.save(student);
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
		Optional<Student> optionalstudent = studentrepository.findById(id);
		if (optionalstudent.isPresent()) {
			Student existiongStudent = optionalstudent.get();
			existiongStudent.setEmail(student.getEmail());
			existiongStudent.setFirstName(student.getFirstName());
			existiongStudent.setLastName(student.getLastName());
			return studentrepository.save(existiongStudent);
		}
		return null;
	}
}

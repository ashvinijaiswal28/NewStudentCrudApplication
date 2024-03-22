package com.spring.crud.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.Entity.Course;
import com.spring.crud.Entity.Department;
import com.spring.crud.Entity.Student;
import com.spring.crud.Repository.CourseRepo;
import com.spring.crud.Repository.DepartmentRepo;
import com.spring.crud.Repository.StudentRepository;
import com.spring.crud.Wrapper.StudentDeptCourse;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
	@Autowired
	private StudentRepository studentrepository;

	@Transactional
	public String postStudent(StudentDeptCourse studentWrapper) {
		setStudentFields(studentWrapper);
		return "{\"status\":\"Student Added Successfully.\"}";
	}

	private void setStudentFields(StudentDeptCourse studentWrapper) {
		studentrepository.save(studentWrapper.getStudent());

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

	public Student updateStudent(Long id, StudentDeptCourse student) {
		Optional<Student> optionalStudent = studentrepository.findById(id);
		if (optionalStudent.isPresent()) {
			Student existingStudent = optionalStudent.get();
			existingStudent.setEmail(student.getStudent().getEmail());
			existingStudent.setFirstName(student.getStudent().getFirstName());
			existingStudent.setLastName(student.getStudent().getLastName());
			existingStudent.setContact(student.getStudent().getContact());
			existingStudent.setAge(student.getStudent().getAge());

			
			Department existingDepartment = existingStudent.getDepartment();
			if (existingDepartment == null) {
				existingDepartment = new Department();
			}
			existingDepartment.setDepartmentName(student.getStudent().getDepartment().getDepartmentName());
			existingStudent.setDepartment(existingDepartment);

			
			Course existingCourse = existingStudent.getCourse();
			if (existingCourse == null) {
				existingCourse = new Course();
			}
			existingCourse.setCourseName(student.getStudent().getCourse().getCourseName());
			existingStudent.setCourse(existingCourse);

			return studentrepository.save(existingStudent);
		}
		return null;
	}

	public List<Object[]> getStudentInfo() {
		return studentrepository.getStudentInfo();
	}
}

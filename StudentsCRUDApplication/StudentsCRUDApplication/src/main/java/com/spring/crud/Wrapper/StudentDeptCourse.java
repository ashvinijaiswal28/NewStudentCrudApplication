package com.spring.crud.Wrapper;

import java.util.List;

import com.spring.crud.Entity.Course;
import com.spring.crud.Entity.Department;
import com.spring.crud.Entity.Student;

public class StudentDeptCourse {
	
	private Student student;
	private List<Department> department;
	private List<Course> course;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public List<Department> getDepartment() {
		return department;
	}
	public void setDepartment(List<Department> department) {
		this.department = department;
	}
	public List<Course> getCourse() {
		return course;
	}
	public void setCourse(List<Course> course) {
		this.course = course;
	}
	


	
}

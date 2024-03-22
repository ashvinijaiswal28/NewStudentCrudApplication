package com.spring.crud.Wrapper;

import com.spring.crud.Entity.Course;
import com.spring.crud.Entity.Department;
import com.spring.crud.Entity.Student;

public class StudentDeptCourse {
	
	private Student student;
	private Department department;
	private Course course;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	


	
}

package com.spring.crud.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.crud.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query(value = "SELECT stu.first_name, stu.email, stu.age, c.course_name, d.department_name " + "FROM Students stu "
			+ "LEFT JOIN Departments d ON stu.department_id = d.department_id "
			+ "LEFT JOIN Courses c ON c.course_id = stu.course_id where stu.student_id=:id", nativeQuery = true)
	public List<Object[]> getStudentInfo();


	
	  List<Student> findByFirstName(String firstName);
	  //hello
}

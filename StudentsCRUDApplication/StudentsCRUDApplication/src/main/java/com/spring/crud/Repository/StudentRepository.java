package com.spring.crud.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.crud.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByFirstName(String firstName);

	@Query("SELECT s FROM Student s WHERE s.firstName like %:firstName%")
	List<Student> search(String firstName);

	List<Student> findByDepartmentId(Long id);

	@Query("SELECT s FROM Student s JOIN s.department d WHERE (:firstName IS NULL OR s.firstName LIKE %:firstName%) OR (:departmentName IS NULL OR d.departmentName = :departmentName)")
	List<Student> searchStudentsNDepartment(String firstName, String departmentName);
}

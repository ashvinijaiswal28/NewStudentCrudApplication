package com.spring.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.crud.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}

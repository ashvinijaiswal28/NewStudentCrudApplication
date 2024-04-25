package com.spring.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.crud.Entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}

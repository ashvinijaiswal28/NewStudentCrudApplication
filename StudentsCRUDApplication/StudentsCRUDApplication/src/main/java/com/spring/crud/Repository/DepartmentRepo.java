package com.spring.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.crud.Entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

}

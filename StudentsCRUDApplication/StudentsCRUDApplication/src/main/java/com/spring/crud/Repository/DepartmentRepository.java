package com.spring.crud.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.crud.Entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	@Query("SELECT dept FROM Department  dept")
    List<Department> getDepartmentMasterData();
}

package com.spring.crud.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.crud.Entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {


	@Query("SELECT  cour  FROM  Course cour")
    List<Course> getCoursetMasterData();
}

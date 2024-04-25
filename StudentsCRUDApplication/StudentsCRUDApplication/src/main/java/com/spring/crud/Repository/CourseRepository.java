package com.spring.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.crud.Entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {


}

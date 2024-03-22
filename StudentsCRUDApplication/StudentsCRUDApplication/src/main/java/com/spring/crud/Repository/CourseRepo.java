package com.spring.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.crud.Entity.Course;

public interface CourseRepo extends JpaRepository<Course, Long> {

}

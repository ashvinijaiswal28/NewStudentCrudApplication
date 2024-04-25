package com.spring.crud.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "course_department_data")
public class courseDeptData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;


	  @Column(name = "name", unique = true)
	  private String name;

	@Column(name = "code", unique = true)
	  private String code;

	public enum DeptCourseType {
	    course, department;
	  }

	@Column(name = "type")
	  @Enumerated(EnumType.STRING)
	  private DeptCourseType type;

	
	public courseDeptData(Long id, String name, String code, DeptCourseType type) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.type = type;
	}
	
	
	public courseDeptData() {
		super();
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public DeptCourseType getType() {
		return type;
	}

	public void setType(DeptCourseType type) {
		this.type = type;
	}
	
	
}

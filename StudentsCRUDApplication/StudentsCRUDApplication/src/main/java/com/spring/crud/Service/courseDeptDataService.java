package com.spring.crud.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.Entity.courseDeptData;
import com.spring.crud.Repository.courseDeptDatarepository;
@Service
public class courseDeptDataService {

	@Autowired
	private courseDeptDatarepository courseDeptDatarepository;
	
	public List<courseDeptData> getDepartmentMasterData(courseDeptData.DeptCourseType type) {
		return courseDeptDatarepository.getDepartmentMasterData(type);
	}
}

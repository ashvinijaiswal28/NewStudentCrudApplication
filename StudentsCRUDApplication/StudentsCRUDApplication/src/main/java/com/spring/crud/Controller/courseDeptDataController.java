package com.spring.crud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.Entity.courseDeptData;
import com.spring.crud.Service.courseDeptDataService;

@RestController
@RequestMapping("/masterData")
@CrossOrigin("*")
public class courseDeptDataController {

	@Autowired
	courseDeptDataService  courseDeptDataService;
	
	 @GetMapping("/getDepartmentMasterData")
	   public List<courseDeptData> getDepartmentMasterData(@RequestParam  courseDeptData.DeptCourseType  type) {
	        return courseDeptDataService.getDepartmentMasterData(type);
	        
	    }

}

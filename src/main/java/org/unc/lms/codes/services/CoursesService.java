package org.unc.lms.codes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unc.lms.codes.repository.CoursesRepository;

@Service
public class CoursesService {

	@Autowired
	public CoursesRepository coursesRepository; 
	

	
	public List<String> getCourses(String dept_name){
		return coursesRepository.getCourses(dept_name); 
	}
	
	public String getCourseIdByCourseName(String courseName) {
		return coursesRepository.getCourseIdByCourseName(courseName); 
	}
}

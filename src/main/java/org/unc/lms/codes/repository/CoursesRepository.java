package org.unc.lms.codes.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CoursesRepository {

	private static Logger logger = Logger.getLogger(CoursesRepository.class.getName());
	 
	@Autowired
	public JdbcTemplate jdbcTemplate; 

	public List<String> getCourses(String dept_name) {
		String sql = "SELECT c.course_name " +
	             "FROM courses c " +
	             "INNER JOIN department d ON c.dept_id = d.dept_id " +
	             "WHERE LOWER(d.dept_name) = LOWER(?);";		
		
	List<String> courses = jdbcTemplate.queryForList(sql, String.class, dept_name);
	List<String> List = new ArrayList<>();
			courses.forEach(course_name -> List.add(course_name));
 
	    return List; 
	}
	
	public String getCourseIdByCourseName(String courseName) {
		String sql = "SELECT course_id FROM courses WHERE course_name = ?"; 
		
		List<String> courses = jdbcTemplate.queryForList(sql, String.class, courseName);

	    if (courses.isEmpty()) {
	        return null;  // Department not found
	    } else {
	        return courses.get(0);  // Return the first department_id found
	    }
		
	}
}
 
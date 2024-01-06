package org.unc.lms.codes.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.unc.lms.codes.model.data.Student;


@Repository
public class StudentRepository {

	private static Logger logger = Logger.getLogger(StudentRepository.class.getName()); 
	
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	@Transactional
	public boolean addStudent(Student s) {
	    try {
	        String sql = "INSERT INTO Users(student_id, first_name, middle_name, last_name, suffix, unc_email, phone_num, dept_id, course_id,"
	        		+ "  user_type, ez_name, password, librarycard_number, yearlevel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        jdbcTemplate.update(sql, s.getStudentId(), s.getFirstName(), s.getMiddleName(), s.getLastName(), s.getSuffix(),
	        					s.getUncEmail(), s.getPhoneNum(), s.getDeptId(), s.getCourseId(), s.getUserType() , s.getEzName(), 
	        					s.getPassword(), s.getLibraryCardNumber(), s.getYearLevel());
	        return true;
	    } catch (Exception e) {
	        logger.severe(e.getMessage());
	        return false;
	    }
	}
	
	public Student selectStudent(String studentId) {
		String sql = "SELECT student_id, ez_name, first_name, middle_name, last_name, suffix, unc_email, phone_num, dept_id, course_id, user_type, librarycard_number, yearlevel " +
	             "FROM Users WHERE student_id = ?";
		 List<Student> student = jdbcTemplate.query(sql, new PreparedStatementSetter() {
			 @Override
			 public void setValues(PreparedStatement preparedStatement) throws SQLException {
		            preparedStatement.setString(1, studentId);
		        }
		 }, new RowMapper<Student>() {
			 @Override
			 public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				 String studentId = rs.getString("student_id"); 
				 String ezName = rs.getString("ez_name"); 
	             String firstName = rs.getString("first_name"); 
	             String middleName = rs.getString("middle_name"); 
	             String lastName = rs.getString("last_name"); 
	             String suffix = rs.getString("suffix"); 
	             String uncEmail = rs.getString("unc_email"); 
//	             String course = rs.getString("course"); 
	             String phoneNum = rs.getString("phone_num");
	             String deptId = rs.getString("dept_id"); 
	             String courseId = rs.getString("course_id"); 
	             String userType = rs.getString("user_type"); 
	             String libraryCardNum = rs.getString("librarycard_number"); 
	             String yearLevel = rs.getString("yearlevel"); 
	             
				 Student s = new Student(); 
				 
				 s.setStudentId(studentId); 
				 s.setEzName(ezName);
				 s.setFirstName(firstName);
				 s.setMiddleName(middleName);
				 s.setLastName(lastName);
				 s.setSuffix(suffix);
				 s.setUncEmail(uncEmail);
				 s.setPhoneNum(phoneNum);
				 s.setDeptId(deptId);
				 s.setCourseId(courseId);
				 s.setUserType(userType);
				 s.setLibraryCardNumber(libraryCardNum);
				 s.setYearLevel(yearLevel);
				 
			

				 return s; 
			 }
		 }); 
		 return student.isEmpty() ? null : student.get(0);
	}
	
}

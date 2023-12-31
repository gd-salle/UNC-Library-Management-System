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
			String sql = "INSERT INTO StudUsers(student_id, firstname, middlename, lastname, suffix, unc_email, course, phone_num) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; 
			jdbcTemplate.update(sql, s.getStudentId(), s.getFirstName(), s.getMiddleName(), s.getLastName(), s.getSuffix(), s.getUncEmail(), s.getCourse(), s.getPhoneNum()); 
			return true; 
		} catch (Exception e) {
			logger.severe(e.getMessage());
			return false; 
		}
	}
	
	public Student selectStudent(String studentId) {
		 String sql = "SELECT student_id, firstname, middlename, lastname, suffix, unc_email, course, phone_num " +
                 "FROM StudUsers WHERE student_id = ?";
		 List<Student> student = jdbcTemplate.query(sql, new PreparedStatementSetter() {
			 @Override
			 public void setValues(PreparedStatement preparedStatement) throws SQLException {
		            preparedStatement.setString(1, studentId);
		        }
		 }, new RowMapper<Student>() {
			 @Override
			 public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				 String studentId = rs.getString("student_id"); 
	             String firstName = rs.getString("firstname"); 
	             String middleName = rs.getString("middlename"); 
	             String lastName = rs.getString("lastname"); 
	             String suffix = rs.getString("suffix"); 
	             String uncEmail = rs.getString("unc_email"); 
	             String course = rs.getString("course"); 
	             String phoneNum = rs.getString("phone_num"); 
	             
				 Student s = new Student(); 
				 
				 s.setStudentId(studentId); 
				 s.setFirstName(firstName);
				 s.setMiddleName(middleName);
				 s.setLastName(lastName);
				 s.setSuffix(suffix);
				 s.setUncEmail(uncEmail);
				 s.setCourse(course);
				 s.setPhoneNum(phoneNum);
			
				 
				 return s; 
			 }
		 }); 
		 return student.isEmpty() ? null : student.get(0);
	}
	
}

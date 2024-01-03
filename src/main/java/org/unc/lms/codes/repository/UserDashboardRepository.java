package org.unc.lms.codes.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.unc.lms.codes.model.data.UserDashboard;

@Repository
public class UserDashboardRepository {
	private static Logger logger = Logger.getLogger(StudentRepository.class.getName()); 
		
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	public UserDashboard selectBook(String studentID) {
		String sql = "select title, returndate,borroweddate,fine from book where student_id = ?";
		
		List<UserDashboard> borrowedLogs = jdbcTemplate.query(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement preparedStatment) throws SQLException {
				
			}
		}, new RowMapper<UserDashboard>() {
			@Override
			public UserDashboard mapRow(ResultSet rs, int rowNum) throws SQLException{
				String title = rs.getString("title");
				Date returnDate = rs.getDate("returndate");
				Date borrowedDate = rs.getDate("borroweddate");
				Double fine = rs.getDouble("fine");
				
				UserDashboard logs = new UserDashboard();
				
				logs.setBookTitle(title);
				logs.setBorrowedDate(borrowedDate);
				logs.setReturnDate(returnDate);
				logs.setFine(fine);
				
				return logs;
			}
		});
		
		
		if (borrowedLogs.isEmpty()) {
			return null;
		} else {
			return borrowedLogs.get(0);
		}
	}
}
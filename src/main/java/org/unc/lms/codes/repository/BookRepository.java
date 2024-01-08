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
import org.unc.lms.codes.model.data.Book;
import org.unc.lms.codes.model.data.Student;

@Repository
public class BookRepository {
	
private static Logger logger = Logger.getLogger(StudentRepository.class.getName()); 
	
	@Autowired
	public JdbcTemplate jdbcTemplate;

	public boolean addBook(Book b) {
		try {
			String sql = "INSERT INTO book(title, author, genre, yearpublished)"
					+ "VALUES (?,?,?,?)";
			
			jdbcTemplate.update(sql,b.getTitle(),b.getAuthor(),b.getGenre(),b.getYearPublished());
			
			return true;
		} catch(Exception e) {
			logger.severe(e.getMessage());
			return false;
		}
	}
}

package org.unc.lms.codes.repository;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.unc.lms.codes.model.data.Book;

@Repository
public class BookRepository {
	
private static Logger logger = Logger.getLogger(StudentRepository.class.getName()); 
	
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	
}

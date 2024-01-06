package org.unc.lms.codes.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class DepartmentRepository {

	//private static Logger logger = Logger.getLogger(DepartmentRepository.class.getName());
	
	@Autowired
	public JdbcTemplate jdbcTemplate; 
	
	
	
	public List<String> selectAllDept() {
	    String sql = "SELECT dept_name FROM department";
	    
	    List<String> departments = jdbcTemplate.query(sql, new RowMapper<String>() {

	        @Override
	        public String mapRow(ResultSet rs, int rowNum) throws SQLException {
	            String deptName = rs.getString("dept_name");
	            return deptName;
	        }
	    });

	    return departments;
	}
	
	public String getDeptIdByDeptName(String deptName) {
	    String sql = "SELECT dept_id FROM department WHERE dept_name = ?";
	    
	    List<String> departments = jdbcTemplate.queryForList(sql, String.class, deptName);

	    if (departments.isEmpty()) {
	        return null;  // Department not found
	    } else {
	        return departments.get(0);  // Return the first department_id found
	    }
	}

	
}

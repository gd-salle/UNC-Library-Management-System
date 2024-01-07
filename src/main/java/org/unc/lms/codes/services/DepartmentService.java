package org.unc.lms.codes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unc.lms.codes.repository.DepartmentRepository;

@Service
public class DepartmentService {

	
	@Autowired
	public DepartmentRepository departmentRepository; 
	
	
	public List<String> getAllDeptName(){
		return departmentRepository.selectAllDept(); 
	}
	
	public String getDeptIdByDeptName(String dept_name) {
		return departmentRepository.getDeptIdByDeptName(dept_name); 
		
	} 
}
      
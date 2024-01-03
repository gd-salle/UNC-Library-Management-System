package org.unc.lms.codes.services;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unc.lms.codes.repository.StudentRepository;
import org.unc.lms.codes.repository.UserDashboardRepository;

@Service
public class UserDashboardServices {
	
	@Autowired
	public UserDashboardRepository userDashboardRepository; 
	
	private static Logger logger = Logger.getLogger(StudentService.class.getName());
	
	
}

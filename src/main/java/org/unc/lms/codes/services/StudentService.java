package org.unc.lms.codes.services;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unc.lms.codes.model.data.User;
import org.unc.lms.codes.model.form.LibraryRegistrationForm;
import org.unc.lms.codes.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	public StudentRepository studentRepository; 
	@Autowired
	public DepartmentService departmentService; 
	@Autowired
	public CoursesService coursesService; 
	
	private static Logger logger = Logger.getLogger(StudentRepository.class.getName());
	
	public boolean addStudentData(LibraryRegistrationForm libraryRegistrationForm) {
		String deptName = libraryRegistrationForm.getDepartment();
		String courseName = libraryRegistrationForm.getCourse(); 
		
        String deptId = departmentService.getDeptIdByDeptName(deptName);
        String courseId = coursesService.getCourseIdByCourseName(courseName); 
	    try {
	        // Map data from LibraryRegistrationForm to Student
	        User s = new User();
	        s.setStudentId(libraryRegistrationForm.getStudentId());
	        s.setEzName(libraryRegistrationForm.getEzName());
	        s.setPassword(libraryRegistrationForm.getPassword());
	        s.setFirstName(libraryRegistrationForm.getFirstName());
	        s.setMiddleName(libraryRegistrationForm.getMiddleName());
	        s.setLastName(libraryRegistrationForm.getLastName());
	        s.setSuffix(libraryRegistrationForm.getSuffix());
	        s.setUncEmail(libraryRegistrationForm.getUncEmail());
	        s.setCourseId(courseId);
	        s.setPhoneNum(libraryRegistrationForm.getPhoneNum());
	        s.setDeptId(deptId);
	        s.setUserType(libraryRegistrationForm.getUserType());
	        s.setLibraryCardNumber(libraryRegistrationForm.getLibraryCardNumber());
	        s.setYearLevel(libraryRegistrationForm.getYearLevel());

	        // Save the student to the database
	        return studentRepository.addStudent(s);
	    } catch (Exception e) {
	        logger.severe(e.getMessage());
	        return false;
	    }
	}
	
	public User getStudentData(String studentId) { 
		return studentRepository.selectStudent(studentId); 
	}

}

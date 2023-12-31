package org.unc.lms.codes.services;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unc.lms.codes.model.data.Student;
import org.unc.lms.codes.model.form.LibraryRegistrationForm;
import org.unc.lms.codes.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	public StudentRepository studentRepository; 
	
	private static Logger logger = Logger.getLogger(StudentService.class.getName());
	
	public boolean addStudentData(LibraryRegistrationForm libraryRegistrationForm) {
		try {
			//Map data from LibraryRegistrationForm to Student
			Student s = new Student(); 
			s.setStudentId(libraryRegistrationForm.getStudentId());
			s.setFirstName(libraryRegistrationForm.getFirstName());
			s.setMiddleName(libraryRegistrationForm.getMiddleName());
			s.setLastName(libraryRegistrationForm.getLastName()); 
			s.setSuffix(libraryRegistrationForm.getSuffix());
			s.setUncEmail(libraryRegistrationForm.getUncEmail());
			s.setCourse(libraryRegistrationForm.getCourse());
			s.setPhoneNum(libraryRegistrationForm.getPhoneNum());
			
			//Save the student to the database
			return studentRepository.addStudent(s); 
		} catch(Exception e) {
			logger.severe(e.getMessage());
			return false; 
		}
	}
	
	public Student getStudentData(String studentId) { 
		return studentRepository.selectStudent(studentId); 
	}

}

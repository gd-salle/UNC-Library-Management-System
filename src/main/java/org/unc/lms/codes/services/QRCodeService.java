package org.unc.lms.codes.services;

import org.springframework.stereotype.Service;
import org.unc.lms.codes.model.data.Student;

@Service
public class QRCodeService {

	public String generateQRCodeContent(Student student) {
	    return "Name: " + student.getFirstName() +
	            (student.getMiddleName() != null ? " " + student.getMiddleName().charAt(0) + "." : "") +
	            (student.getLastName() != null ? " " + student.getLastName() : "") +
	            "\nStudent ID: " + student.getStudentId() +
	            "\nDepartment: " + (student.getDeptId() != null ? student.getDeptId() : "") +
	            "\nCourse: " + (student.getCourseId() != null ? student.getCourseId() : "") +
	            "\nYear/Grade Level: " + (student.getYearLevel() != null ? student.getYearLevel() : "") +
	            "\nUNC Email: " + (student.getUncEmail() != null ? student.getUncEmail() : "") +
	            "\nPhone Number: " + (student.getPhoneNum() != null ? student.getPhoneNum() : "") +
	            "\nLibrary Card Number: " + (student.getLibraryCardNumber() != null ? student.getLibraryCardNumber() : "");
	} 
          

}            
                        
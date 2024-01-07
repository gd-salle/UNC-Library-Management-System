package org.unc.lms.codes.services;

import org.springframework.stereotype.Service;
import org.unc.lms.codes.model.data.Student;

@Service
public class QRCodeService {

public String generateQRCodeContent(Student student) {

    	
        return "Name: " + student.getFullName() +
               ", Student ID: " + student.getStudentId() +
               ", Department: " + student.getDeptId() + 
               ", Course: " + student.getCourseId() +
               ", Year/Grade Level: " + student.getYearLevel() +
               ", UNC Email: " + student.getUncEmail() +
               ", Phone Number: " + student.getPhoneNum() + 
               ", Library Card Number: " + student.getLibraryCardNumber();
    }
}

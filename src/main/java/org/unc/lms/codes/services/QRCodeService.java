package org.unc.lms.codes.services;

import org.springframework.stereotype.Service;
import org.unc.lms.codes.model.data.User;

@Service
public class QRCodeService {

public String generateQRCodeContent(User student) {

    	
        return "Name: " + student.getFirstName() +
               ", Student ID: " + student.getStudentId() +
               ", Department: " + student.getDeptId() + 
               ", Course: " + student.getCourseId() +
               ", Year/Grade Level: " + student.getYearLevel() +
               ", UNC Email: " + student.getUncEmail() +
               ", Phone Number: " + student.getPhoneNum() + 
               ", Library Card Number: " + student.getLibraryCardNumber();
    }
}

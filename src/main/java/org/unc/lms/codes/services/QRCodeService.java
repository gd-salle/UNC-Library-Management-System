package org.unc.lms.codes.services;

import org.springframework.stereotype.Service;
import org.unc.lms.codes.model.data.Student;

@Service
public class QRCodeService {

    public String generateQRCodeContent(Student student) {
        // Customize this method based on the data you want to include in the QR code
        return student.getFirstName() + " " + student.getLastName() +
               ", Student ID: " + student.getStudentId() +
               ", Course: " + student.getCourse() +
               ", UNC Email: " + student.getUncEmail() +
               ", Phone Number: " + student.getPhoneNum();
    }
}

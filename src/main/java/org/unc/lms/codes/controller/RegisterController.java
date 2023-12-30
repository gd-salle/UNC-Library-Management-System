package org.unc.lms.codes.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.unc.lms.codes.components.QRCodeGenerator;
import org.unc.lms.codes.model.data.Student;
import org.unc.lms.codes.model.form.LibraryRegistrationForm;
import org.unc.lms.codes.services.QRCodeService;
import org.unc.lms.codes.services.StudentService;

import com.google.zxing.WriterException;

@Controller
public class RegisterController {
	
	 @Autowired
	 private QRCodeGenerator qrCodeGenerator;
	 @Autowired
	 private StudentService studentService; 
	 @Autowired
	 private QRCodeService 	qRCodeService; 
	 
	@RequestMapping(path = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
		model.addAttribute("libraryRegistrationForm", new LibraryRegistrationForm()); 
        return "LibraryCardRegisterView";
    }
	
	@GetMapping("/student/qr")
	public ResponseEntity<byte[]> getQRCode(String studentId) {
		Student student = studentService.getStudentData(studentId); 
	    String text = qRCodeService.generateQRCodeContent(student);
	    //debugging
	    System.out.println("Student data received: " + text);
	    byte[] bytes = null;
	    try {
	        bytes = qrCodeGenerator.generateQRCodeImage(text, 200, 200);
	    } catch (WriterException | IOException e) {
	        e.printStackTrace(); // Handle the exception appropriately in your production code
	    }

	    if (bytes != null && bytes.length > 0) {
	        final HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.IMAGE_PNG);
	        return new ResponseEntity<>(bytes, headers, HttpStatus.CREATED);
	    } else {
	        System.out.println("Error: Generated QR code bytes are null or empty.");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	    
	}




	@RequestMapping(path = "register", method = RequestMethod.POST)
	public String showLibraryCard(Model model, @ModelAttribute LibraryRegistrationForm libraryRegistrationForm) {
//		Add the data of the form to the Student Model
		studentService.addStudentData(libraryRegistrationForm);
	    
	    System.out.println("Library Registration Form data: " + libraryRegistrationForm.toString());
	    
	    model.addAttribute("libraryRegistrationForm", libraryRegistrationForm);
	    model.addAttribute("qrCodeUrl", "/student/qr");  // Updated URL without studentId
	   
	    return "generateLibraryCardView";
	}

	
}
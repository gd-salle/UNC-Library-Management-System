package org.unc.lms.codes.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.unc.lms.codes.components.QRCodeGenerator;
import org.unc.lms.codes.model.data.User;
import org.unc.lms.codes.model.form.LibraryRegistrationForm;
import org.unc.lms.codes.services.CoursesService;
import org.unc.lms.codes.services.DepartmentService;
import org.unc.lms.codes.services.LibraryCardNumberService;
import org.unc.lms.codes.services.QRCodeService;
import org.unc.lms.codes.services.StudentService;
import org.unc.lms.codes.services.UserService;

import com.google.zxing.WriterException;

@Controller
public class RegisterController {
	  
	 @Autowired
	 private QRCodeGenerator qrCodeGenerator;
	 @Autowired
	 private StudentService studentService; 
	 @Autowired
	 private UserService userService; 
	 @Autowired
	 private QRCodeService 	qRCodeService; 
	 @Autowired
	 private DepartmentService departmentService;
	 @Autowired
	 private CoursesService coursesService; 
	 @Autowired
	 private LibraryCardNumberService libraryCardNumberService; 
	 
	@RequestMapping(path = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
	
		 // Generate a library card number
        String libraryCardNumber = libraryCardNumberService.generateLibraryCardNumber();
        
		System.out.println(libraryCardNumber); 
		List<String> departmentNames = departmentService.getAllDeptName();
		
		LibraryRegistrationForm libraryRegistrationForm = new LibraryRegistrationForm(); 
		libraryRegistrationForm.setLibraryCardNumber(libraryCardNumber); 
		
		model.addAttribute("departmentNames", departmentNames);
		model.addAttribute("libraryCardNumber", libraryCardNumber); 
		model.addAttribute("libraryRegistrationForm", libraryRegistrationForm); 
		
        return "LibraryCardRegisterView";
    }    
	 
	@GetMapping("/student/qr")
	public ResponseEntity<byte[]> getQRCode(String studentId) {
		User student = userService.getStudentData(studentId); 
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
     
	@GetMapping("/get-courses")
	public ResponseEntity<List<String>> getCourses(@RequestParam("department") String dept_name) {
	    try {
	        List<String> courses = coursesService.getCourses(dept_name);
	        return ResponseEntity.ok(courses);
	    } catch (Exception e) {
	        // Log the exception
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
	    }
	}
     
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String showLibraryCard(Model model, @ModelAttribute LibraryRegistrationForm libraryRegistrationForm) {
		userService.addStudentData(libraryRegistrationForm);
	    
	    System.out.println("Library Registration Form data: " + libraryRegistrationForm.toString());
	    
	    model.addAttribute("libraryRegistrationForm", libraryRegistrationForm);
	    model.addAttribute("qrCodeUrl", "/student/qr?studentId=" + libraryRegistrationForm.getStudentId());

	    return "generateLibraryCardView";
	}
}
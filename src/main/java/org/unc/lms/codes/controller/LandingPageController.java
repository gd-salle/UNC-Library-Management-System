package org.unc.lms.codes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.unc.lms.codes.model.form.LibraryRegistrationForm;
import org.unc.lms.codes.services.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LandingPageController {
	
	@Autowired
    private AuthenticationManager authenticationManager;
	@Autowired
	private UserService userService; 
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private static final Logger logger = LoggerFactory.getLogger(LandingPageController.class);


	//LOGIN
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String viewHome(Model model) {
		model.addAttribute("libraryRegistrationForm", new LibraryRegistrationForm());
		return "LandingPage"; 
	}
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
    public String loginSubmit(@ModelAttribute LibraryRegistrationForm libraryRegistrationForm, HttpServletRequest request) {
		logger.info("Entering loginSubmit method");
		logger.info("Student ID: {}", libraryRegistrationForm.getStudentId());
		logger.info("Password: {}", libraryRegistrationForm.getPassword());

        // Authenticate the user
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(libraryRegistrationForm.getStudentId(), libraryRegistrationForm.getPassword())
            );

            // Authentication successful
            SecurityContextHolder.getContext().setAuthentication(authentication);
            // Retrieve hashed password from the database (you need to implement this)
            String storedPasswordHash = userService.getStoredPasswordHash(libraryRegistrationForm.getStudentId());
            System.out.println(libraryRegistrationForm.getPassword()); 
            System.out.println(storedPasswordHash); 
            // Log stored password hash
            logger.info("Stored Password Hash: {}", storedPasswordHash);
            // Check if passwords match
            if (passwordEncoder.matches(libraryRegistrationForm.getPassword(), storedPasswordHash)) {
                // Passwords match, user is authenticated
                return "LMSLandingPage";
            } else {
                // Passwords do not match, authentication fails
                logger.info("Authentication failed: Passwords do not match");
                return "/?loginError=true";
            }
        } catch (AuthenticationException e) {
            // Authentication failed
        	logger.error("Authentication failed: {}", e.getMessage());
            return "/login?loginError=true";
        }
    }
	
	 @RequestMapping(path = "/LMSLandingPage", method = RequestMethod.GET)
	    public String viewLMSLandingPage(Model model) {
	        // Logic for LMS landing page
	        return "LMSLandingPage";
	    }
	
	
}

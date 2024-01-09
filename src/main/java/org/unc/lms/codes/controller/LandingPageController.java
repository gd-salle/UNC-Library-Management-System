package org.unc.lms.codes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.unc.lms.codes.model.form.LibraryRegistrationForm;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LandingPageController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(LandingPageController.class);


	//LOGIN
	@RequestMapping(path = "/login", method = RequestMethod.GET)
    public String viewHome(Model model, HttpServletRequest request) {
        model.addAttribute("libraryRegistrationForm", new LibraryRegistrationForm());
        return "LandingPage";
    }
	
	
	@RequestMapping("/LMSLandingPage")
	public String viewLMSLandingPage(Model model, Authentication authentication) {
	    model.addAttribute("authentication", authentication);
	    return "LMSLandingPage";
	}

	
	@GetMapping("/logout")
    public String logout() {
        return "redirect:/login?logout=true";
    } 
	
	@GetMapping("/loginRequest")
	public String accessDenied() {
	    return "redirect:/login?loginRequest";
	}

	
}

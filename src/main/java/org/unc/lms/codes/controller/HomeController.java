package org.unc.lms.codes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/lms")
public class HomeController {

	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String viewHome(Model model) {
		return "HomeView"; 
	}
	
	
	
}

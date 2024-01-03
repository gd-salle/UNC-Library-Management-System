package org.unc.lms.codes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/lms")
public class BorrowerDashboardController {
	
	@RequestMapping(path = "/user/dashboard", method = RequestMethod.GET)
	public String viewDashboard(Model model) {
		return null;
	}
	
}

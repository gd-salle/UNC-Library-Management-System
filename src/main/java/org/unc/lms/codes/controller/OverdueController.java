package org.unc.lms.codes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/lms")
public class OverdueController {
	
	@RequestMapping(path="/user/logs", method = RequestMethod.GET)
	public String overduePage(Model model) {
		return "overduePage";
	}
}

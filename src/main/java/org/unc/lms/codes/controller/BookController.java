package org.unc.lms.codes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.unc.lms.codes.model.form.BookCreationForm;
import org.unc.lms.codes.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(path="/book/creation", method = RequestMethod.GET)
	public String initBookCreation(Model model) {
		model.addAttribute("bookCreationForm", new BookCreationForm());
		return "BookCollection";
	}
	
	@RequestMapping(path="/book/creation", method = RequestMethod.POST)
	public String bookCreated(Model model, @ModelAttribute BookCreationForm bookCreationForm) {
		
		bookService.createBook(bookCreationForm);
		model.addAttribute("bookCreationForm", bookCreationForm);
		return "BookCollection";
	}
}
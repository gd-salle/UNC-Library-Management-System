package org.unc.lms.codes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.unc.lms.codes.model.data.Book;
import org.unc.lms.codes.model.form.BookCreationForm;
import org.unc.lms.codes.services.BookService;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(path = "/book/add", method = RequestMethod.GET)
    public String initBookCreation(Model model) {
        model.addAttribute("bookCreationForm", new BookCreationForm());
        model.addAttribute("success", false); // Initialize success attribute
        model.addAttribute("fail", false); // Initialize fail attribute
        return "AddNewBook";
    }

    @RequestMapping(path = "/book/add", method = RequestMethod.POST)
    public String bookCreated(Model model, @ModelAttribute BookCreationForm bookCreationForm) {
        // Call the service method to create a book
        boolean isBookCreated = bookService.createBook(bookCreationForm);

        if (isBookCreated) {
            // Book created successfully
            model.addAttribute("success", true);
            model.addAttribute("fail", false);
            model.addAttribute("successMessage","Book added successfully!");
        } else {
            // Book creation failed
            model.addAttribute("success", false);
            model.addAttribute("fail", true);
            model.addAttribute("errorMessage","Duplicate book found!!");
        }

        model.addAttribute("bookCreationForm", new BookCreationForm()); // Clear the form
        return "AddNewBook";
    }
    
    public String bookEdit(Model model) {
    	return "EditBook";
    }
    
    @RequestMapping(path="/collection", method=RequestMethod.GET)
    public String getBookCollection(Model model) {
    	List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "BookCollection";
    }
}
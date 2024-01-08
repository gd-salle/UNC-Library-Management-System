package org.unc.lms.codes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.unc.lms.codes.model.data.Book;
import org.unc.lms.codes.model.form.BookForm;
import org.unc.lms.codes.services.BookService;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(path = "/book/add", method = RequestMethod.GET)
    public String initBookCreation(Model model) {
        model.addAttribute("bookCreationForm", new BookForm());
        model.addAttribute("success", false); // Initialize success attribute
        model.addAttribute("fail", false); // Initialize fail attribute
        return "AddNewBook";
    }

    @RequestMapping(path = "/book/add", method = RequestMethod.POST)
    public String bookCreated(Model model, @ModelAttribute BookForm bookCreationForm) {
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

        model.addAttribute("bookCreationForm", new BookForm()); // Clear the form
        return "AddNewBook";
    }
    
    @RequestMapping(path="/book/edit/{id}", method = RequestMethod.GET)
    public String bookEdit(Model model, @PathVariable Long id) {
        Book b = bookService.getBookById(id);
        model.addAttribute("updateForm", b);  // Use "book" as the key
        return "EditBook";
    }

    @RequestMapping(path="/book/edit/{id}")
    public String updateBook(Model model, @PathVariable Long id, @ModelAttribute BookForm updateForm) {
    	boolean updated = bookService.updateBook(id, updateForm);

    	if (updated) {
            model.addAttribute("successMessage", "Book updated successfully!");
        } else {
            model.addAttribute("errorMessage", "Failed to update the book. Please try again.");
        }

        return "redirect:/book/collection";
    }
    
    @RequestMapping(path = "/book/collection", method = RequestMethod.GET)
    public String getBookCollection(@RequestParam(name = "search", required = false) String searchQuery, Model model) {
        List<Book> books;

        if (searchQuery != null && !searchQuery.isEmpty()) {
            books = bookService.searchBooks(searchQuery);
        } else {
            books = bookService.getAllBooks();
        }

        model.addAttribute("books", books);
        model.addAttribute("bookCreationForm", new BookForm()); // Add an empty form for creating new books
        return "BookCollection";
    }

}
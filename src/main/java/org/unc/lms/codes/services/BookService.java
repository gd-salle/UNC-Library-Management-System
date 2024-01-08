package org.unc.lms.codes.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unc.lms.codes.model.data.Book;
import org.unc.lms.codes.model.form.BookForm;
import org.unc.lms.codes.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	public BookRepository bookRepository;
	
	private static Logger logger = Logger.getLogger(StudentService.class.getName());
	
	public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }
	
	public List<Book> searchBooks(String keyword) {
        return bookRepository.searchBooks(keyword);
    }
	
	public Book getBookById(Long id) {
        return bookRepository.getBookById(id);
    }
	
	public boolean createBook(BookForm bookCreationForm) {
		try {
            // Create a Book object from the form data
            Book b = new Book();
            b.setTitle(bookCreationForm.getTitle());
            b.setAuthor(bookCreationForm.getAuthor());
            b.setGenre(bookCreationForm.getGenre());
            b.setYearPublished(bookCreationForm.getYearPublished());

            // Call the repository method to add the book
            boolean isBookAdded = bookRepository.addBook(b);

            if (isBookAdded) {
                // Book added successfully
                return true;
            } else {
                // Book creation failed (likely due to a duplicate)
                return false;
            }
        } catch (Exception e) {
            logger.severe(e.getMessage());
            return false;
        }
	}
	
	public boolean updateBook(Long id, BookForm updateForm) {
	    try {
	        Book existingBook = bookRepository.getBookById(id);
	        if (existingBook != null) {
	            // Update the existing book with the data from the update form
	            existingBook.setTitle(updateForm.getTitle());
	            existingBook.setAuthor(updateForm.getAuthor());
	            existingBook.setGenre(updateForm.getGenre());
	            existingBook.setYearPublished(updateForm.getYearPublished());
	            bookRepository.updateBook(existingBook);
	            return true; // Return true if the update is successful
	        }
	    } catch (Exception e) {
	        // Log the exception or handle it as needed
	        e.printStackTrace();
	    }
	    return false; // Return false if the update fails
	}
	
	public boolean deleteBook(Long id) {
        return bookRepository.deleteBook(id);
    }
}
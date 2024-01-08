package org.unc.lms.codes.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unc.lms.codes.model.data.Book;
import org.unc.lms.codes.model.form.BookCreationForm;
import org.unc.lms.codes.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	public BookRepository bookRepository;
	
	private static Logger logger = Logger.getLogger(StudentService.class.getName());
	
	public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }
	
	public List<Book> searchBooks(String keyword){
		return null;
	}
	
	public Book findBookByID(Long id) {
		return null;
	}
	
	public boolean createBook(BookCreationForm bookCreationForm) {
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
	
	public void updateBook() {
		
	}
	
	public void deleteBook() {
		
	}
}
package org.unc.lms.codes.repository;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.unc.lms.codes.model.data.Book;

@Repository
public class BookRepository {
	
private static Logger logger = Logger.getLogger(StudentRepository.class.getName()); 
	
	@Autowired
	public JdbcTemplate jdbcTemplate;

	public boolean addBook(Book b) {
		try {
            // Check if the book already exists
            String checkDuplicateSql = "SELECT COUNT(*) FROM book WHERE title = ? AND author = ?";
            int count = jdbcTemplate.queryForObject(checkDuplicateSql, Integer.class, b.getTitle(), b.getAuthor());

            if (count > 0) {
                // Book with the same title and author already exists, handle it accordingly
                logger.warning("Duplicate book found: " + b.getTitle() + " by " + b.getAuthor());
                return false;
            }

            // If no duplicate found, proceed with insertion
            String insertSql = "INSERT INTO book(title, author, genre, yearpublished) VALUES (?,?,?,?)";
            jdbcTemplate.update(insertSql, b.getTitle(), b.getAuthor(), b.getGenre(), b.getYearPublished());

            return true;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            return false;
        }
	}
	
	public List<Book> getAllBooks() {
        String sql = "SELECT * FROM book";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Book book = new Book();
            book.setId(rs.getLong("id"));
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setGenre(rs.getString("genre"));
            book.setYearPublished(rs.getString("yearpublished"));
            return book;
        });
    }
	
	public List<Book> searchBooks(String keyword) {
        String sql = "SELECT * FROM book WHERE lower(title) LIKE ?";
        String searchTerm = "%" + keyword.toLowerCase() + "%";

        return jdbcTemplate.query(sql, preparedStatement -> preparedStatement.setString(1, searchTerm),
                (rs, rowNum) -> {
                    Book book = new Book();
                    book.setId(rs.getLong("id"));
                    book.setTitle(rs.getString("title"));
                    book.setAuthor(rs.getString("author"));
                    book.setGenre(rs.getString("genre"));
                    book.setYearPublished(rs.getString("yearpublished"));
                    return book;
                });
    }
	
	public Book getBookById(Long id) {
        String sql = "SELECT * FROM book WHERE id = ?";
        try {
            List<Book> books = jdbcTemplate.query(sql, (rs, rowNum) -> {
                Book book = new Book();
                book.setId(rs.getLong("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setGenre(rs.getString("genre"));
                book.setYearPublished(rs.getString("yearpublished"));
                return book;
            }, id);

            return books.isEmpty() ? null : books.get(0);
        } catch (EmptyResultDataAccessException e) {
            return null; // Book with the given id not found
        }
    }
	
	public void updateBook(Book book) {
        String sql = "UPDATE book SET title = ?, author = ?, genre = ?, yearpublished = ? WHERE id = ?";
        jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getGenre(), book.getYearPublished(), book.getId());
    }
}

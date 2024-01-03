package org.unc.lms.codes.model.data;

import java.util.Date;

public class Book {

	private int id;
	private String title;
	private String author;
	private String genre;
	private Date yearPublished;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Date getYearPublished() {
		return yearPublished;
	}
	public void setYearPublished(Date yearPublished) {
		this.yearPublished = yearPublished;
	}
}

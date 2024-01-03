package org.unc.lms.codes.model.data;

import java.util.Date;

public class Overdue {
	private int id;
	private Student studentID; // get the studentID from the entity Student
	private Book bookTitle; // get the book title from the entity book
	private Date dueDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Student getStudentID() {
		return studentID;
	}
	public void setStudentID(Student studentID) {
		this.studentID = studentID;
	}
	public Book getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(Book bookTitle) {
		this.bookTitle = bookTitle;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
}

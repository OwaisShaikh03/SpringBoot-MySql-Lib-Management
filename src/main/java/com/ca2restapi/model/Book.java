
package com.ca2restapi.model; 
import jakarta.persistence.*;

@Entity
public class Book { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId; 
    
	private String bookName;
    private String authorName;
    private double price; 

	public Book() {
		super();
		
	
	}
		public Book(Long bookId, String bookName, String authorName, double price) {
			super();
			this.bookId = bookId;
			this.bookName = bookName;
			this.authorName = authorName;
			this.price = price;
		}
    
    
    public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
   
}

	


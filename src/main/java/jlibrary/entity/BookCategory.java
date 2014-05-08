package jlibrary.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="book_category")
public class BookCategory implements Serializable{

	public BookCategory(){}
	
	public BookCategory(int id, String name) {
		this.bookCategoryId = id;
		this.bookCategoryName = name;
	}
	
	@Id
	@GeneratedValue(generator="system-id") 
	@GenericGenerator(name="system-id",strategy="increment") 
	@Column(name = "category_id", unique = true, nullable = false) 
	private int bookCategoryId;
	
	@Column(name = "category_name", nullable = false) 
	private String bookCategoryName;

	public int getBookCategoryId() {
		return bookCategoryId;
	}

	public void setBookCategoryId(int bookCategoryId) {
		this.bookCategoryId = bookCategoryId;
	}

	public String getBookCategoryName() {
		return bookCategoryName;
	}

	public void setBookCategoryName(String bookCategoryName) {
		this.bookCategoryName = bookCategoryName;
	}
	
	
}

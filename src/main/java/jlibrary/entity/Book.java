package jlibrary.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="books")
public class Book implements Serializable{

	@Id
	@GeneratedValue(generator="system-id") 
	@GenericGenerator(name="system-id",strategy="increment") 
	@Column(name = "book_id", unique = true, nullable = false) 
	private int bookId;
	
	@Column(name = "book_name", length = 50, nullable = false) 
	private String bookName;
	
	@Column(name = "author", length = 50, nullable = false) 
	private String author;
	
	@Column(name = "publish_date")
	private Date publishDate;
	
	@Column(name = "entry_date")
	private Date entryDate;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "intro")
	private String intro;
	
	@Column(name = "total_number")
	private short totalNumber;
	
	@OneToOne
	@JoinColumn(name="category_id")
	private BookCategory bookCategory;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public short getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(short totalNumber) {
		this.totalNumber = totalNumber;
	}

	public BookCategory getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}
	
}

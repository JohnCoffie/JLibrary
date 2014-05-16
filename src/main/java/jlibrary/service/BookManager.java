package jlibrary.service;

import java.util.List;

import jlibrary.entity.Book;
import jlibrary.entity.BookCategory;

public interface BookManager {

	public List<Book> findAllBooks();
	public List<BookCategory> findAllBookCategories();
	public void addBook(Book book);
	public void updateBook(Book book);
	public Book getBookById(int id);
	public void removeBooks(List<Integer> ids);
}

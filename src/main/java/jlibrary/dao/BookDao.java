package jlibrary.dao;

import java.util.List;

import jlibrary.entity.Book;
import jlibrary.entity.BookCategory;

public interface BookDao {

	public List<Book> findAllBooks();
	public List<BookCategory> findAllBookCategories();
	public void addBook(Book book);
	public void updateBook(Book book);
	public Book getBookById(int id);
	public void removeBook(Class clazz, int id);
}

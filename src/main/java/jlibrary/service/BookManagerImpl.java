package jlibrary.service;

import java.util.List;

import jlibrary.dao.BookDao;
import jlibrary.entity.Book;
import jlibrary.entity.BookCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookManager")
public class BookManagerImpl implements BookManager {

	@Autowired
	private BookDao bookDao;
	
	@Override
	public List<Book> findAllBooks() {
		return bookDao.findAllBooks();
	}
	
	@Override
	public List<BookCategory> findAllBookCategories(){
		return bookDao.findAllBookCategories();
	}
	
	@Override
	public void addBook(Book book){
		bookDao.addBook(book);
	}

	@Override
	public void updateBook(Book book){
		bookDao.updateBook(book);
	}
	
	@Override
	public Book getBookById(int id){
		return bookDao.getBookById(id);
	}
	
	@Override
	public void removeBooks(List<Integer> ids){
		for ( Integer id : ids ) {
			bookDao.removeBook(Book.class, id);
		}
	}
}

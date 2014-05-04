package jlibrary.service;

import java.util.List;

import jlibrary.dao.BookDao;
import jlibrary.entity.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookManager")
public class BookManagerImpl implements BookManager {

	@Autowired
	private BookDao bookDao;
	
	@Override
	public List<Book> findAllBooks() {
		return bookDao.findAll();
	}

}

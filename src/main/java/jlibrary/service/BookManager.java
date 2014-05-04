package jlibrary.service;

import java.util.List;

import jlibrary.entity.Book;

public interface BookManager {

	public List<Book> findAllBooks();
}

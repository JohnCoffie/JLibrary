package jlibrary.dao;

import java.util.List;

import jlibrary.entity.Book;

public interface BookDao {

	public List<Book> findAll();
}

package jlibrary.dao;

import java.util.List;

import jlibrary.entity.Book;
import jlibrary.entity.BookCategory;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("bookDao")
public class BookDaoImpl extends BaseDaoImpl implements BookDao {

	private static final Logger log = Logger.getLogger(BookDaoImpl.class.getName());
	
	@Override
	public List<Book> findAllBooks() {
		//String hql = "from Book";
		//Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		log.debug("finding all Book instances");
		return getAllObject(Book.class);
	}
	
	@Override
	public List<BookCategory> findAllBookCategories(){
		log.debug("finding all BookCategory instances");

		return getAllObject(BookCategory.class);
	}
	
	@Override
	public void addBook(Book book){	
		//Session session = sessionFactory.getCurrentSession();
		//session.saveOrUpdate(book);
		
		saveObject(book);
		log.debug("book save successful");
	}
	
	@Override
	public void updateBook(Book book){
		saveObject(book);
		log.debug("book update successful");
	}
	
	@Override
	public Book getBookById(int id){
		Book book = (Book)getObject(Book.class, id);
		return book;
	}
	
	@Override
	public void removeBook(Class clazz, int id){
		removeObject(clazz, id);
		log.debug("book with id: "+id+" delete successful");
	}

}

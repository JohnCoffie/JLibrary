package jlibrary.dao;

import java.util.List;

import jlibrary.entity.Book;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {

	private static final Logger log = Logger.getLogger(BookDaoImpl.class.getName());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Book> findAll() {
		String hql = "from Book";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

}

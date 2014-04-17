package jlibrary.dao;

import jlibrary.entity.User;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;
	
	@Override
	public User findUserById(int id) {
		String hql = "from User where user_id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (User)query.uniqueResult();
	}

}

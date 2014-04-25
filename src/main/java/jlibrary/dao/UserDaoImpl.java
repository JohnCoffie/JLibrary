package jlibrary.dao;

import jlibrary.entity.User;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User findUserById(int id) {
		String hql = "from User u where u.userId = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		//Query query = sessionFactory.getCurrentSession().createSQLQuery("select * from users where user_id = ?");
		query.setInteger(0, id);
		User user = (User)query.uniqueResult();
		return user;
	}

}

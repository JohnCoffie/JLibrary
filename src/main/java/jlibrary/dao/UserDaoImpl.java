package jlibrary.dao;

import jlibrary.entity.User;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl implements UserDao {
	
	@Override
	public User findUserById(int id) {
		User user = (User)getObject(User.class, id);
		return user;
	}

}

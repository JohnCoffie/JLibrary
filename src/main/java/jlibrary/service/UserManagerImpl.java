package jlibrary.service;

import jlibrary.dao.UserDao;
import jlibrary.entity.User;

public class UserManagerImpl implements UserManager{

	private UserDao userDao;
	
	public User getUserById(int id) {
		return userDao.findUserById(id);
	}
}

package jlibrary.service;

import jlibrary.dao.UserDao;
import jlibrary.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userManager")
public class UserManagerImpl implements UserManager{

	@Autowired
	private UserDao userDao;
	
	public User getUserById(int id) {
		return userDao.findUserById(id);
	}

}

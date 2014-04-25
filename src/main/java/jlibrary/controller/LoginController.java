package jlibrary.controller;

import javax.servlet.http.HttpServletRequest;

import jlibrary.dao.UserDao;
import jlibrary.entity.User;
import jlibrary.service.UserManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user") 
public class LoginController {

	@Autowired
	private UserManager userManager;
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/login")
	public String login(String username, String password, HttpServletRequest request) {
		User user = userManager.getUserById(Integer.valueOf(username));
		
		if ( user == null ) {
			System.out.println("No such user");
			return "login";
			
		} else if ( !password.equals(user.getPassword()) ) {
			System.out.println("No such user");
			return "login";
			
		} else {
			return "welcome";
		}
	}

}

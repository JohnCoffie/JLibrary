package jlibrary.controller;

import javax.servlet.http.HttpServletRequest;

import jlibrary.dao.UserDao;
import jlibrary.entity.User;
import jlibrary.service.UserManager;
import jlibrary.util.Constants;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user") 
public class LoginController {

	@Autowired
	private UserManager userManager;
	
	private static final Logger log = Logger.getLogger(LoginController.class.getName());
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if ( checkLoginParams(new String[]{username, password}) ) {
			User user = userManager.getUserById(Integer.valueOf(username));
			
			if ( user == null ) {
				if ( log.isDebugEnabled() )
					log.debug("no such user: "+username);
				return new ModelAndView(Constants.HOME_PAGE);
				
			} else if ( !password.equals(user.getPassword()) ) {
				if ( log.isDebugEnabled() )
					log.debug("password incorrect for user: "+username);
				return new ModelAndView(Constants.HOME_PAGE);
				
			} else {
				if ( log.isDebugEnabled() )
					log.debug("got user: "+username);
				return new ModelAndView(Constants.MAIN_PAGE);
			}
		}
		return new ModelAndView(Constants.HOME_PAGE);
		
	}
	
	/**
	 * Check if the parameters for login are valid or not
	 * @param params
	 * @return
	 */
	private boolean checkLoginParams(String[] params) {
		for ( String param :  params ) {
			if ( param == null || param.trim().equals("") ) {
				if ( log.isDebugEnabled() )
					log.debug("no arguement passed in during login");
				return false;
			}
		}
		return true;
	}

}

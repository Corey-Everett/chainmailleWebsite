package com.chainmailleWebsite.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import DAOs.DAO;
import DAOs.EmailDAO;
import DAOs.ItemDAO;
import DAOs.UserDAO;
import entities.Item;
import entities.User;


@SessionAttributes(value= {"emailDeniedErrorMessage"})
@Controller
public class indexController {
	// Final variables for webpage names, all conveniently in one place.
	String[] indexName = {"/","/index"};
	
// These requests just map to a page
	@RequestMapping("/")
	public ModelAndView showIndex() {
		return new ModelAndView("index");
	}
	@RequestMapping("/index")
	public ModelAndView getIndex() {
		return new ModelAndView("index");
	}
	@RequestMapping("/homepage")
	public ModelAndView showHomepage() {
		return new ModelAndView("homepage");
	}
	@RequestMapping("/header")
	public ModelAndView showHeader() {
		return new ModelAndView("header");
	}
	@RequestMapping("/aboutus")
	public ModelAndView showAbout() {
		return new ModelAndView("aboutus");
	}
	@RequestMapping("/login")
	public ModelAndView showLogin() {
		return new ModelAndView("login");
	}
//	@RequestMapping("/admindashboard")
//	public ModelAndView showAdminDashboard() {
//		return new ModelAndView("admindashboard");
//	}
	@RequestMapping("/registration")
	public ModelAndView showRegistration() {
		return new ModelAndView("registration");
	}
	@RequestMapping("/bracelets")
	public ModelAndView showBracelets() {
		return new ModelAndView("bracelets");
	}
	@RequestMapping("/necklaces")
	public ModelAndView showNecklaces() {
		return new ModelAndView("necklaces");
	}
	@RequestMapping("/special")
	public ModelAndView showSpecial() {
		return new ModelAndView("special");
	}

	

	
	// Special requests
	
	// This method passes a valid email to the email list. 
	@RequestMapping("/submitEmail")
	public ModelAndView registerEmailToList(@RequestParam("email") String email) throws ClassNotFoundException, SQLException {
		
	    String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	    boolean matches = email.matches(regex);
	    
	    DAO dao = new DAO();
	    // Check to see if email is already on list
	    if (dao.queryDatabase("SELECT EMAIL FROM EMAIL WHERE EMAIL = \""+ email + "\";").next()) {
		    ModelAndView mav = new ModelAndView("homepage");
			mav.addObject("emailDeniedErrorMessage", "Email already on list!");
			return mav;
	}
	    if (matches) {
		EmailDAO emailDAO = new EmailDAO();
		
		emailDAO.registerEmail(email);
		
		ModelAndView mav = new ModelAndView("homepage");
		mav.addObject("email", email);
		mav.addObject("emailDeniedErrorMessage", "Email successfully added to mailing list!");
		
		return mav;
	    } else {
	    ModelAndView mav = new ModelAndView("homepage");
		mav.addObject("emailDeniedErrorMessage", "Invalid email. Try again!");
		return mav;
	    }
	}

	@RequestMapping("/register")
	public ModelAndView getRegistration(@ModelAttribute("userkey") User user) {
		// Process inputs
		System.out.println("username = "+user.getUserName());
		
		ModelAndView mav = new ModelAndView("profile");
		mav.addObject("user", user);
		
		return mav;
	}
	
	@RequestMapping("/showusers")
	public ModelAndView showAllUsers() {
		UserDAO userDAO = new UserDAO();
		List<User> userList;
		try {
			
			
			userList = userDAO.getAllUsers();
			ModelAndView mav = new ModelAndView("allUsers");
		mav.addObject("listOfUsers", userList);
		return mav;
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		return null;
		
	}
}

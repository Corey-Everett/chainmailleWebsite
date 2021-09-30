package com.chainmailleWebsite.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import DAOs.DAO;
import DAOs.ItemDAO;
import DAOs.OrderDAO;
import DAOs.UserDAO;
import entities.Item;
import entities.Order;
import entities.User;


import java.util.ArrayList;

//                         Username                 "Username or password failed"
@SessionAttributes(value= {"userLogin", "userType", "userFirstName", "mavDeniedErrorMessage", "cart", "activeOrders", "users"})
@Controller
public class UserSessionController {

	// This should validate the entry
	@RequestMapping("/userLogin") 
	public ModelAndView loginToSystem(@RequestParam("username") String username, @RequestParam("password") String password) throws SQLException, ClassNotFoundException{

		System.out.println("UserSession:userLogin: Start"); // Test
		
		ModelAndView mavVerified = new ModelAndView("homepage");
		ModelAndView mavDenied = new ModelAndView("login");

		boolean isVerified = false;

		UserDAO userDAO = new UserDAO();
		
		
		if (userDAO.getUserByUsername(username) != null) {
		User loginUser = userDAO.getUserByUsername(username);
		System.out.print("UserSession:userLogin: User returned from database: " + loginUser.getUserName());
		} else {
			System.out.println("UserSession:userLogin: No user returned.");
			mavDenied.addObject("mavDeniedErrorMessage","User not found!");
			return mavDenied;
		}
		User loginUser = userDAO.getUserByUsername(username);
		if (loginUser.getPassword().equals(password)) {
			isVerified = true;
		} else {
			System.out.println("Password (" +loginUser.getPassword() + ") not verified to password entered. If it is, there's an error.");
			mavDenied.addObject("mavDeniedErrorMessage","Password does not match username. Please try again.");
		}
		
		// Proceed, based on validation, to homepage (validated) or login page (not validated).
		if (isVerified) {
			mavVerified.addObject("userLogin",username);
			mavVerified.addObject("userFirstName", loginUser.getFirstName());
			mavDenied.addObject("mavDeniedErrorMessage","");
			return mavVerified;	
		} else {
			return mavDenied;
		}

	}
	// This should log the user out.
		@RequestMapping("/userLogout") 
		public ModelAndView logoutOfSystem() {
			
			ModelAndView mav = new ModelAndView("homepage");
			
			mav.addObject("userLogin", "");
			
			return mav;

		}
		// This function registers a new user to the database.
		@RequestMapping("/userRegistration")  
		public ModelAndView registerUser(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname , @RequestParam("street") String street, @RequestParam("streetDetail") String streetDetail, @RequestParam("city") String city, @RequestParam("state") String state, @RequestParam("postalcode") String postalcode, @RequestParam("email") String email) throws ClassNotFoundException, SQLException, IOException {
			
			// Start by testing inputs. Shouldn't have to access the database if the user provided garbage, right?
			
			if (username == null || username == "" || password == null || password == "") {
				ModelAndView mav = new ModelAndView("registration");
				mav.addObject("registrationErrorMessage", "Username and password must have inputs.");
				return mav;
			}
			
			
			// If it passes the "garbage" test, start checking the database to make sure there are no duplicate entries.
			ModelAndView mav = new ModelAndView("homepage");
			
			UserDAO userDAO = new UserDAO();
			
			List<User> userList = userDAO.getAllUsers();
			
			
			// Validate all input. Cannot have the same username or email as someone already
			for (User user: userList) {

				if (user.getUserName().equals(username)) {
					mav = new ModelAndView("registration");
					mav.addObject("registrationErrorMessage", "Username already exists!");
					return mav;
				}
				if (user.getEmail().equals(email)) {
					mav = new ModelAndView("registration");
					mav.addObject("registrationErrorMessage", "Email already in use!");
					return mav;
				}
				
			}

			// Insert user into database
			DAO dao = new DAO();
			dao.updateDatabase("INSERT INTO User(username, firstname, lastname, street, streetDetail, city, state, postalCode, admin, password, email) VALUES ( \"" + username + "\", \"" + firstname + "\", \"" + lastname + "\", \"" + street + "\", \"" + streetDetail + "\", \"" + city + "\", \"" + state + "\", \"" + postalcode + "\", \"user\", \"" + password + "\", \"" + email + "\");");
			mav = new ModelAndView("homepage");
			return mav;

		}

		@RequestMapping("/cart")
		public ModelAndView showCart(@SessionAttribute("userLogin") String username) throws ClassNotFoundException, SQLException, IOException {
			
			// The first step is to get the userID of the user submitting this request.
			ItemDAO itemDAO = new ItemDAO();
			
			UserDAO userDAO = new UserDAO();
			
			DAO dao = new DAO();
			
			
			User loginUser = userDAO.getUserByUsername(username);
			
			System.out.print("Login user's userID: " + loginUser.getUserID());
			
			// Get a list of every item a customer has ordered and isn't an old order
			ResultSet orderResultSet = dao.queryDatabase("SELECT * FROM `order` where userID = " + loginUser.getUserID() + " AND orderComplete = 0;");
			
			
			
			ArrayList<Item> itemList = new ArrayList<Item>();
		
			while (orderResultSet.next()) {

				itemList.add(itemDAO.getItemByID(orderResultSet.getInt(3)));
				}


			ModelAndView mav = new ModelAndView("cart");
			
			mav.addObject("cart", itemList);
			
			
			return mav;
		}
		
		@RequestMapping("/orderBracelet")
		public ModelAndView orderBracelet(@SessionAttribute("userLogin") String username) throws  SQLException, ClassNotFoundException {
		
			ModelAndView mav = new ModelAndView("bracelets");
			
			DAO dao = new DAO();
			UserDAO userDAO = new UserDAO();
			
			// Get a list of every item a customer has ordered and isn't an old order
			dao.updateDatabase("INSERT INTO `ORDER`(UserID, itemID, ordercomplete) VALUES (" +userDAO.getUserByUsername(username).getUserID() + ", 1701, 0);");
			return mav; 
			
		}
		@RequestMapping("/removeBracelets")
		public ModelAndView orderItem(@SessionAttribute("userLogin") String username) throws ClassNotFoundException, SQLException {
		
			ModelAndView mav = new ModelAndView("bracelets");
			
			DAO dao = new DAO();
			UserDAO userDAO = new UserDAO();
			
			// Get a list of every item a customer has ordered and isn't an old order
			dao.updateDatabase("DELETE FROM `ORDER` WHERE USERID = " +userDAO.getUserByUsername(username).getUserID() + " AND ITEMID = 1701");
			return mav; 
			
		}
		@RequestMapping("/orderNecklace")
		public ModelAndView orderNecklace(@SessionAttribute("userLogin") String username) throws  SQLException, ClassNotFoundException {
		
			ModelAndView mav = new ModelAndView("necklaces");
			
			DAO dao = new DAO();
			UserDAO userDAO = new UserDAO();
			
			// Get a list of every item a customer has ordered and isn't an old order
			dao.updateDatabase("INSERT INTO `ORDER`(UserID, itemID, ordercomplete) VALUES (" +userDAO.getUserByUsername(username).getUserID() + ", 1801, 0);");
			return mav; 
			
		}
		@RequestMapping("/removeNecklaces")
		public ModelAndView removeNecklaces(@SessionAttribute("userLogin") String username) throws ClassNotFoundException, SQLException {
		
			ModelAndView mav = new ModelAndView("necklaces");
			
			DAO dao = new DAO();
			UserDAO userDAO = new UserDAO();
			
			// Get a list of every item a customer has ordered and isn't an old order
			dao.updateDatabase("DELETE FROM `ORDER` WHERE USERID = " +userDAO.getUserByUsername(username).getUserID() + " AND ITEMID = 1801");
			return mav; 
			
		}
		@RequestMapping("/admindashboard")
		public ModelAndView adminDashboard() throws ClassNotFoundException, SQLException, IOException {
		// The first step is to get the userID of the user submitting this request.
		
		DAO dao = new DAO();
		
		// Get a list of every item a customer has ordered and isn't an old order
		ResultSet orderResultSet = dao.queryDatabase("SELECT * FROM `order` where orderComplete = 0;");
	
		ArrayList<Order> orderList = new ArrayList<Order>();
		
		while (orderResultSet.next()) {

			orderList.add(new Order(orderResultSet.getInt(1), orderResultSet.getInt(2), orderResultSet.getInt(3), orderResultSet.getBoolean(4)));
			}

		ModelAndView mav = new ModelAndView("admindashboard");
		
		mav.addObject("activeOrders", orderList);
		
		
		
		ResultSet userResultSet = dao.queryDatabase("SELECT * FROM `user`;");
		
		ArrayList<User> userList = new ArrayList<User>();
		
		while (userResultSet.next()) {

			userList.add(new User(userResultSet.getInt(1), userResultSet.getString(2), userResultSet.getString(3), userResultSet.getString(4), userResultSet.getString(5), userResultSet.getString(6), userResultSet.getString(7), userResultSet.getString(8), userResultSet.getString(9), userResultSet.getString(10), userResultSet.getString(11), userResultSet.getString(12)));
			}
		
		mav.addObject("users", userList);
		
		return mav; 
			
		}
		
}

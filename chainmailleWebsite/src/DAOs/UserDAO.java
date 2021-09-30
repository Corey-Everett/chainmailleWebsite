package DAOs;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.User;

public class UserDAO extends DAO {
	
	/** Test method for UserDAO, troubleshoot to see if it's working.*/
	public static void main(String[] args) {
		
		UserDAO userDAO = new UserDAO();
		
		try {
			
			List<User> userList = userDAO.getAllUsers();
			
			for (User USERr: userList) {
				System.out.println("UserID:" +USERr.getUserID());
				System.out.println("User name:" +USERr.getUserName());
				System.out.println("First name:" +USERr.getFirstName());
				System.out.println("Last name:" +USERr.getLastName());
				System.out.println("Street:" +USERr.getStreet());
				System.out.println("Street Detail:" +USERr.getStreetDetail());
				System.out.println("City:" +USERr.getCity());
				System.out.println("State:" +USERr.getState());
				System.out.println("PostalCode:" +USERr.getPostalCode());
				System.out.println("Admin Role:" +USERr.getAdminRole());
				System.out.println("Password:" +USERr.getPassword());
				System.out.println("Email:" +USERr.getEmail());
				
				
			}
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	/** Get all users from the database.*/
	public List<User> getAllUsers() throws SQLException, IOException, ClassNotFoundException {

		
		try {

			ResultSet rs = super.queryDatabase("SELECT * FROM USER;");
			List<User> userList = new ArrayList<User>();
			System.out.println("RESULT: " + rs); // 
			while (rs.next()) {
				// Each iteration creates a new user and adds it to the userList.
				//                1.ID          2.Username		3.First name	  4. Last name     5. Street        6. Street Detail 7. City          8. State         9. Postal Code   10. Admin         11. Password      12. Email	
				User u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
				userList.add(u);
			}
			return userList;
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			e.getStackTrace();
		}
		return null;
	} // End of getAllUsers method
	
	/** Registers a user to the specified database. 
	 * @throws ClassNotFoundException */
	public boolean registerUser(User user) throws ClassNotFoundException {
		try {
			super.updateDatabase("INSERT INTO User(username, firstname, lastname, street, streetDetail, city, state, postalCode, admin, password, email) VALUES ( \"" + user.getUserName() + "\", \"" + user.getFirstName() + "\", \"" + user.getLastName() +"\", \"" + user.getStreet() + "\", \"" + user.getStreetDetail() + "\", \"" + user.getCity() + "\", \"" + user.getState() + "\", \"" + user.getPostalCode() + "\", \"" + user.getAdminRole() + "\", \"" + user.getPassword() + "\", \"" + user.getEmail() + "\");  ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	} // End of registerUser method
	
	
	public User getUserByUsername(String username) {
		
		ResultSet rs;
		try {
			rs = super.queryDatabase("SELECT * FROM USER WHERE USERNAME = \"" + username + "\";");
			System.out.println("getUserByUsername: SQL Command entered: \"SELECT * FROM USER WHERE USERNAME =\"" + username + "\";");
		
			if (rs.next()) {
			User u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
			return u;
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Error in getUserByUsername - returned null.");
		return null;
	}
}

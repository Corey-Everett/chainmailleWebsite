// Name: Corey Everett
// Date: May 22nd, 2019
// Program: Home Insurance Case Study
// Purpose: To model a complete application and emulate a Home Insurance Program.

package DAOs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MariaDBConnection {
	
	// Database information accessed. 
	static final String url = "jdbc:mariadb://localhost:3306/chainmailwebsite";
	static final String uname = "root";
	static final String pass = "root";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		
		// Establish variables
		Statement statement = null;
		ResultSet queryResult = null;
		
		try {
			
		// Creates a connection with the database.
		Class.forName("org.mariadb.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, uname, pass); System.out.println("Connection established!");
		
		statement = connection.createStatement();
		queryResult = statement.executeQuery("SELECT * FROM user");
		
		System.out.println("Command should've executed.");
		//System.out.println(queryResult);
		 while (queryResult.next()) {
	             int userID = queryResult.getInt("id");
	             String userName = queryResult.getString("username");
	             String password = queryResult.getString("password");
	             String adminRole = queryResult.getString("admin");
	      
	            System.out.println(userID + "\t" + userName + "\t" + password + "\t" + adminRole);
	            
	        } 
		} catch(SQLException e) {e.printStackTrace();}
		
	}

	/**Gets a connection with the database specified in MariaDBConnection.java using the DriverManager class. 
	 * @throws ClassNotFoundException */
	
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		System.out.println("GETCONNECTION");
//		Connection connection = DriverManager.getConnection(url, uname, pass);
		
		
	//----------------------
		
		Statement statement = null;
		ResultSet queryResult = null;
		Connection connection = null;
		try {
			
		// Creates a connection with the database.
		Class.forName("org.mariadb.jdbc.Driver");
		 connection = DriverManager.getConnection(url, uname, pass); System.out.println("Connection established!");
		
//		statement = connection.createStatement();
//		queryResult = statement.executeQuery("SELECT * FROM user");
//		
//		System.out.println("Command should've executed.");
//		//System.out.println(queryResult);
//		 while (queryResult.next()) {
//	             int userID = queryResult.getInt("id");
//	             String userName = queryResult.getString("username");
//	             String password = queryResult.getString("password");
//	             String adminRole = queryResult.getString("admin");
//	      
//	            System.out.println(userID + "\t" + userName + "\t" + password + "\t" + adminRole);
//	            
//	        } 
		} catch(SQLException e) {e.printStackTrace();}	
		
	//-----------------------
		
			
		
		return connection;
	}
	}


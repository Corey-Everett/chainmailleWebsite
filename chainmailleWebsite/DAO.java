// Name: Corey Everett
// Date: May 28th, 2019
// Program: Meta Data Access Object
// Purpose: This program is intended to expand the idea of a DAO and make simpler the CRUD methods for the DAO child objects. 

package DAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Superclass for all DAOs. Easy way to connect to the database or change things in a way that all DAOs use. 
public class DAO {
	
	/** Returns a ResultSet of your input query to specified database. */
	public ResultSet queryDatabase(String inputQuery) throws SQLException {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		MariaDBConnection mariaDB = new MariaDBConnection();

		try {
			
			conn = mariaDB.getConnection(); System.out.println("Connected to database."); // Troubleshooting

			stmt = conn.createStatement();

			rs = stmt.executeQuery(inputQuery);
			
			
		} catch (SQLException e) {

			System.out.println("Error: " + e.getMessage());
			e.getStackTrace();
		} finally {
			if (conn!= null) {
				conn.close();
			}
		}

		return rs;
		
	} // End queryDatabase()

	
	
	
	/** Updates database according to input query. */
	public void updateDatabase(String inputQuery) throws SQLException {
		
		Connection conn = null;
		Statement stmt = null;
		
		MariaDBConnection mariaDB = new MariaDBConnection();
		
		try {

			conn = mariaDB.getConnection();  System.out.println("Connected to database."); // Troubleshooting

			stmt = conn.createStatement();

			stmt.executeUpdate(inputQuery);
			
			
		} catch (SQLException e) {

			System.out.println("Error: " + e.getMessage());
			e.getStackTrace();
		} finally {
			if (conn!= null) {
				conn.close();
			}
		}
		
	} // End updateDatabase()
	
} // End method
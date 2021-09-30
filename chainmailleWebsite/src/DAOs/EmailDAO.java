package DAOs;

import java.sql.SQLException;

public class EmailDAO extends DAO {

	public void registerEmail(String email) throws ClassNotFoundException {
		try {
			updateDatabase("INSERT INTO Email(email) VALUES (\"" + email + "\")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // End of registerEmail method
	
	
	
	
}

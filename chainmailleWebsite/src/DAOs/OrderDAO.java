package DAOs;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Order;

public class OrderDAO extends DAO {
	
	/** Get all users from the database.*/
	public List<Order> getAllOrders() throws SQLException, IOException, ClassNotFoundException {

		ResultSet rs = super.queryDatabase("SELECT * FROM ORDER;");

		try {
			List<Order> orderList = new ArrayList<Order>();
			while (rs.next()) {
				// Each iteration creates a new order and adds it to the orderList.
				Order o = new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getBoolean(4));
				orderList.add(o);
			}
			return orderList;
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			e.getStackTrace();
		}
		return null;
	} // End of getAllOrders method
} // End of OrderDAO class


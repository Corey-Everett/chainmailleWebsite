package DAOs;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Item;

public class ItemDAO extends DAO {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		ItemDAO itemDAO = new ItemDAO();
		
		Item item = itemDAO.getItemByID(1701);
		
		System.out.println(item.getId() +item.getWeave());
		
		
	}
	public List<Item> getAllItems() throws SQLException, IOException, ClassNotFoundException {

		ResultSet rs = super.queryDatabase("SELECT * FROM ITEM;");

		try {
			List<Item> itemList = new ArrayList<Item>();
			while (rs.next()) {
				// Each iteration creates a new item and adds it to the itemList.
				Item i = new Item(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
				itemList.add(i);
			}
			return itemList;
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			e.getStackTrace();
		}
		return null;
	} // End of getAllItems method
	public Item getItemByID(int ID) throws SQLException, IOException, ClassNotFoundException {
		
		ResultSet rs = super.queryDatabase("Select * FROM item where id = " + ID +";");
	
		
		while (rs.next()) {
		Item item = new Item(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
		System.out.print("ID" +rs.getInt(1)+ "COLOR" + rs.getString(2)+ "WEAVE" + rs.getString(3)+ "MATERIAL " +rs.getString(4)+ "PRICE" +rs.getInt(5)+ "DESCRIPTION" + rs.getString(6));
		return item;
		}
	return null;
	
	} // End of getItemByIDs method
	
	
	
} // End of ItemDAO

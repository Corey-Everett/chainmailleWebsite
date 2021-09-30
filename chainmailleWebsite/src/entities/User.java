package entities;

public class User {
	
	private final int userID;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String street;
	private String streetDetail;
	private String city;
	private String state;
	private String postalCode;
	private String adminRole;
	private String email;
	
	
	
	/** Default constructor for User */
	public User() {
		this.userID = 0;
		this.userName = null;
		this.firstName = null;
		this.lastName = null;
		this.street = null;
		this.streetDetail = null;
		this.city = null;
		this.state = null;
		this.postalCode = null;
		this.adminRole = "user";
		this.password = null;
		this.email = null;
		
	}
	
	/** Loaded constructor for User class */
	public User(
	int userID,
	String userName,

	 String firstName,
	 String lastName,
	 String street,
	 String streetDetail,
	 String city,
	 String state,
	 String postalCode,
	 String adminRole,
     String password,
     String email) {
		this.userID = userID;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.streetDetail = streetDetail;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.adminRole = adminRole;
		this.password = password;
		this.email = email;
		
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStreetDetail() {
		return streetDetail;
	}
	public void setStreetDetail(String streetDetail) {
		this.streetDetail = streetDetail;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getAdminRole() {
		return adminRole;
	}
	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
	}
	public int getUserID() {
		return userID;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	

}

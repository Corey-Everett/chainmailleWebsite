package entities;

public class Order {
private final int id;
private final int itemId;
private final int userId;
private boolean orderComplete;


/** Default constructor for Order class. */
public Order() {
	this.id = 0;
	this.itemId = 0;
	this.userId = 0;
	this.orderComplete = false;
}

/** Loaded constructor for Order class.*/
public Order(int id,
int itemId,
int userId,
boolean orderComplete) {
	this.id = id;
	this.itemId = itemId;
	this.userId = userId;
	this.orderComplete = orderComplete;
}
public boolean isOrderComplete() {
	return orderComplete;
}
public void setOrderComplete(boolean orderComplete) {
	this.orderComplete = orderComplete;
}
public int getId() {
	return id;
}
public int getItemId() {
	return itemId;
}
public int getUserId() {
	return userId;
}
}

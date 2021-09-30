package entities;

public class Item {

	private final int id;
	private String color;
	private String weave;
	private String material;
	private double price;
	private String description;
	
	
	/** Default constructor for Item class */
	public Item() {
		
		this.id = 0;
		this.color = null;
		this.weave= null;
		this.material= null;
		this.price= 0;
		this.description= null;
	}
	/** Loaded constructor for item class */
	public Item(int id,
	 String color,
	 String weave,
	 String material,
	 double price,
	 String description) {
		this.id = id;
		this.color = color;
		this.weave= weave;
		this.material= material;
		this.price= price;
		this.description= description;
		
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getWeave() {
		return weave;
	}
	public void setWeave(String weave) {
		this.weave = weave;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	
	
	
}

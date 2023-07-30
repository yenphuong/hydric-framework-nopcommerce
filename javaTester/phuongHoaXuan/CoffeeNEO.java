package phuongHoaXuan;

public class CoffeeNEO {

	// Thuộc tính: Variable/ Property
	public String espresso = "Cafe Espresso";
	
	protected String orangeFruit = "Orange Fruit";

	String lemonFruit = "Lemon Fruit";
	
	private String neoCafe = "Neo's Cafe";	
	
	// Phương thức: Method/ Function
	public void shipEspresso() {
		System.out.println("Ship cafe: " + espresso);
	}

	protected void shipOrange() {
		System.out.println("Ship orange: " + orangeFruit);
	}
	
	void shipLemon() {
		System.out.println("Ship lemon: " + lemonFruit);
	}
	
	private void shipNeoCafe() {
		System.out.println("Ship Cafe NEO: " + neoCafe);
	}
	public static void main(String[] args) {
		CoffeeNEO neo = new CoffeeNEO();
		neo.shipEspresso();
		neo.shipOrange();
		neo.shipLemon();
		neo.shipNeoCafe();
	}
}

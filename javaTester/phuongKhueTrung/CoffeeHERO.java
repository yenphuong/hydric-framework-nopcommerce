package phuongKhueTrung;

import phuongHoaXuan.CoffeeNEO;

public class CoffeeHERO extends CoffeeNEO {

	public static void main(String[] args) {
		CoffeeHERO hero = new CoffeeHERO();
		hero.createCafe();
	}

	public void createCafe() {
		// Capuccino

		//
		System.out.println("Get espresso cafe: " + espresso);
		shipEspresso();

		shipOrange();
		// shipLemon():
	}
}

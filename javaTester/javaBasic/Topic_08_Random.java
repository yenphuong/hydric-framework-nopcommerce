package javaBasic;

import java.util.Calendar;
import java.util.Random;

import org.openqa.selenium.support.ui.Sleeper;

public class Topic_08_Random {

	public static void main(String[] args) throws InterruptedException {
		Random rand = new Random();
		System.out.println(rand.nextInt(99));
		System.out.println(rand.nextInt(999));
		System.out.println(rand.nextInt(9999));

		// Tang so len thi giam ti le trung lap lai
		System.out.println(rand.nextInt(99999));

		System.out.println(getRanndomNumberByDateTime());
		Thread.sleep(1000);

	}

	protected String getMailRandom() {
		Random rand = new Random();
		return "john" + rand.nextInt(99999) + "ken.us";
	}

	public static long getRanndomNumberByDateTime() {
		return Calendar.getInstance().getTimeInMillis() % 100000;
	}

	public static int getRandomNumber() {
		int uLimit = 999;
		int lLimit = 100;
		Random rand = new Random();
		return lLimit + rand.nextInt(uLimit - lLimit);
	}

	public static int getRandomNumber(int minimum, int maximum) {
		Random rand = new Random();
		return minimum + rand.nextInt(maximum - minimum);
	}
}

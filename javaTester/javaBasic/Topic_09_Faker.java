package javaBasic;

import java.util.Locale;

import com.github.javafaker.Faker;

public class Topic_09_Faker {

	public static void main(String[] args) {
		Faker faker = new Faker(new Locale("{vi}"));
		System.out.println(faker.address().firstName());
		System.out.println(faker.address().city());
		System.out.println(faker.address().fullAddress());
		System.out.println(faker.address().timeZone());
		System.out.println(faker.address().secondaryAddress());
		System.out.println(faker.phoneNumber().phoneNumber());
		System.out.println(faker.internet().emailAddress());
		System.out.println(faker.slackEmoji().emoji());
	}

}

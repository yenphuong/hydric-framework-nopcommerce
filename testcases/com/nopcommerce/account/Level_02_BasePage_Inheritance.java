package com.nopcommerce.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_BasePage_Inheritance extends BasePage {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac")) { // Mac
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		} else { // Windows
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		}
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
	}

	@Test
	public void Register_01_Empty_Data() {
		openPageUrl(driver, "https://demo.nopcommerce.com/");

		clickToElement(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"),
				"First name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"),
				"Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		openPageUrl(driver, "https://demo.nopcommerce.com/");

		clickToElement(driver, "//a[@class='ico-register']");

		sendkeyToElement(driver, "//input[@id='FirstName']", "John");
		sendkeyToElement(driver, "//input[@id='LastName']", "Hihi");
		sendkeyToElement(driver, "//input[@id='Email']", "john@hihi@abc");
		sendkeyToElement(driver, "//input[@id='Password']", "123456");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
	}

	@Test
	public void Register_03_Invalid_Password() {
		openPageUrl(driver, "https://demo.nopcommerce.com/");

		clickToElement(driver, "//a[@class='ico-register']");

		sendkeyToElement(driver, "//input[@id='FirstName']", "John");
		sendkeyToElement(driver, "//input[@id='LastName']", "Hihi");
		sendkeyToElement(driver, "//input[@id='Email']", "john@hihi.com");
		sendkeyToElement(driver, "//input[@id='Password']", "12");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "12");

		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"),
				"Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_04_Incorrect_Confirm_Password() {
		openPageUrl(driver, "https://demo.nopcommerce.com/");

		clickToElement(driver, "//a[@class='ico-register']");

		sendkeyToElement(driver, "//input[@id='FirstName']", "John");
		sendkeyToElement(driver, "//input[@id='LastName']", "Hihi");
		sendkeyToElement(driver, "//input[@id='Email']", "john@hihi.com");
		sendkeyToElement(driver, "//input[@id='Password']", "123456");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "122456");

		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"),
				"The password and confirmation password do not match.");
	}

	@Test
	public void Register_05_Success() {
		openPageUrl(driver, "https://demo.nopcommerce.com/");

		clickToElement(driver, "//a[@class='ico-register']");

		sendkeyToElement(driver, "//input[@id='FirstName']", "John");
		sendkeyToElement(driver, "//input[@id='LastName']", "Hihi");
		sendkeyToElement(driver, "//input[@id='Email']", getEmailRandom());
		sendkeyToElement(driver, "//input[@id='Password']", "123456");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public String getEmailRandom() {
		Random rand = new Random();
		return "john" + rand.nextInt(99999) + "@hihi.com";
	}
}

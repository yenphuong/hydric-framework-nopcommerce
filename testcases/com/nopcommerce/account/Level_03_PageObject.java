package com.nopcommerce.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.RegisterPageObject;

public class Level_03_PageObject extends BasePage {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String osName = System.getProperty("os.name");
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private CustomerPageObject customerPage;
	private UserLoginPageObject loginPage;
	private String emailAddress = getEmailRandom();

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

		openPageUrl(driver, "https://demo.nopcommerce.com/");

		homePage = new HomePageObject(driver);
	}

	@Test
	public void User_01_Register_Empty_Data() {
		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMessageText(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMessageText(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessageText(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessageText(), "Password is required.");
	}

	@Test
	public void User_02_Register_Invalid_Email() {
		registerPage.clickToNopCommerceLogo();

		homePage = new HomePageObject(driver);

		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);

		registerPage.enterToFirstNameTextbox("John");
		registerPage.enterToLastNameTextbox("Hihi");
		registerPage.enterToEmailTextbox("john@hihi@abc");
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getEmailErrorMessageText(), "Wrong email");
	}

	@Test
	public void User_03_Register_Invalid_Password() {
		registerPage.clickToNopCommerceLogo();

		homePage = new HomePageObject(driver);

		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);

		registerPage.enterToFirstNameTextbox("John");
		registerPage.enterToLastNameTextbox("Hihi");
		registerPage.enterToEmailTextbox("john@hihi.com");
		registerPage.enterToPasswordTextbox("12");
		registerPage.enterToConfirmPasswordTextbox("12");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getPasswordErrorMessageText(),
				"Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void User_04_Register_Incorrect_Confirm_Password() {
		registerPage.clickToNopCommerceLogo();

		homePage = new HomePageObject(driver);

		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);

		registerPage.enterToFirstNameTextbox("John");
		registerPage.enterToLastNameTextbox("Hihi");
		registerPage.enterToEmailTextbox("john@hihi.com");
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123356");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessageText(),
				"The password and confirmation password do not match.");
	}

	@Test
	public void User_05_Register_Success() {
		registerPage.clickToNopCommerceLogo();

		homePage = new HomePageObject(driver);

		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);

		registerPage.enterToFirstNameTextbox("John");
		registerPage.enterToLastNameTextbox("Hihi");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");

	}

	@Test
	public void User_06_Register_Login_Success() {
		registerPage.clickToNopCommerceLogo();

		homePage = new HomePageObject(driver);

		homePage.clickToLoginLink();

		loginPage = new UserLoginPageObject(driver);

		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox("123456");

		loginPage.clickToLoginButton();

		homePage = new HomePageObject(driver);

		homePage.clickToMyAccountLink();

		customerPage = new CustomerPageObject(driver);

		Assert.assertEquals(customerPage.getFirstNameTextboxAttributeValue(), "John");
		Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(), "Hihi");
		Assert.assertEquals(customerPage.getEmailAddressTextboxAttributeValue(), emailAddress);

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

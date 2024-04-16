package com.nopcommerce.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.RegisterPageObject;

public class Level_21_Pattern_Object extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private CustomerPageObject customerPage;
	private UserLoginPageObject loginPage;
	private String emailAddress = getEmailRandom();

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowerDriver(browserName);
		
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void User_01_Register_Empty_Data() {
		homePage.clickToHeaderLinkByName("Register");
		
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		registerPage.clickToButtonByText("Register");
		Assert.assertEquals(registerPage.getTextboxErrorMessageById("FirstName"), "First name is required.");
		Assert.assertEquals(registerPage.getTextboxErrorMessageById("LastName"), "Last name is required.");
		Assert.assertEquals(registerPage.getTextboxErrorMessageById("Email"), "Email is required.");
		Assert.assertEquals(registerPage.getTextboxErrorMessageById("Password"), "Password is required.");
		Assert.assertEquals(registerPage.getTextboxErrorMessageById("ConfirmPassword"), "Password is required.");
		
	}

	@Test
	public void User_02_Register_Invalid_Email() {
		homePage = registerPage.clickToNopCommerceLogo();

		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		registerPage.enterToTextboxById("FirstName","John");
		registerPage.enterToTextboxById("LastName","Hihi");
		registerPage.enterToTextboxById("Email","john@hihi@abc");
		registerPage.enterToTextboxById("Password","123456");
		registerPage.enterToTextboxById("ConfirmPassword","123456");

		registerPage.clickToButtonByText("Register");

		Assert.assertEquals(registerPage.getTextboxErrorMessageById("Email"), "Wrong email");
	}

	@Test
	public void User_03_Register_Invalid_Password() {
		homePage = registerPage.clickToNopCommerceLogo();

		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		registerPage.enterToTextboxById("FirstName","John");
		registerPage.enterToTextboxById("LastName","Hihi");
		registerPage.enterToTextboxById("Email","john@hihi.com");
		registerPage.enterToTextboxById("Password","12");
		registerPage.enterToTextboxById("ConfirmPassword","12");

		registerPage.clickToButtonByText("Register");

		Assert.assertEquals(registerPage.getTextboxErrorMessageById("Password"),
				"Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void User_04_Register_Incorrect_Confirm_Password() {
		homePage = registerPage.clickToNopCommerceLogo();

		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		registerPage.enterToTextboxById("FirstName","John");
		registerPage.enterToTextboxById("LastName","Hihi");
		registerPage.enterToTextboxById("Email","john@hihi.com");
		registerPage.enterToTextboxById("Password","123456");
		registerPage.enterToTextboxById("ConfirmPassword","123356");

		registerPage.clickToButtonByText("Register");
		
		Assert.assertEquals(registerPage.getTextboxErrorMessageById("ConfirmPassword"),
				"The password and confirmation password do not match.");
	}

	@Test
	public void User_05_Register_Success() {
		homePage = registerPage.clickToNopCommerceLogo();

		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);

		
		registerPage.enterToTextboxById("FirstName","John");
		registerPage.enterToTextboxById("LastName","Hihi");
		registerPage.enterToTextboxById("Email",emailAddress);
		registerPage.enterToTextboxById("Password","123456");
		registerPage.enterToTextboxById("ConfirmPassword","123456");

		registerPage.clickToButtonByText("Register");

		Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");

	}

	@Test
	public void User_06_Register_Login_Success() {
		homePage = registerPage.clickToNopCommerceLogo();

		homePage.clickToHeaderLinkByName("Log in");
		loginPage = PageGeneratorManager.getLoginPage(driver);

		
		loginPage.enterToTextboxById("Email", emailAddress);
		loginPage.enterToTextboxById("Password","123456");

		loginPage.clickToButtonByText("Log in");
		
		homePage = PageGeneratorManager.getHomePage(driver);

		homePage.clickToHeaderLinkByName("My account");
		customerPage = PageGeneratorManager.getCustomerPage(driver);
		
		Assert.assertEquals(customerPage.getTextboxAttributeById("FirstName", "value"), "John");
		Assert.assertEquals(customerPage.getTextboxAttributeById("LastName", "value"), "Hihi");
		Assert.assertEquals(customerPage.getTextboxAttributeById("Email", "value"), emailAddress);
		
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}

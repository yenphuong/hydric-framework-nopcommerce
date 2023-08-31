package com.nopcommerce.account;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;

public class Level_16_Log extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	//private SearchPageObject searchPage;
	private String emailAddress = getEmailRandom();

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowerDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void User_01_Register_Success() {
		log.info("Register - Step 1: Verify Register link displayed");
		verifyFalse(homePage.isRegisterLinkDisplayed());
		
		log.info("Register - Step 2: Click to Register link");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register - Step 3: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 4: Verify error message at Firstname textbox");
		verifyEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");
		
		log.info("Register - Step 5: Verify error message at Lastname textbox");
		verifyEquals(registerPage.getLastNameErrorMessageText(), "Last name is required");
		
		log.info("Register - Step 6: Verify Firstname textbox");
		registerPage.enterToFirstNameTextbox("John");
		
		log.info("Register - Step 7: Verify Lastname textbox");
		registerPage.enterToLastNameTextbox("Hihi");
		
		log.info("Register - Step 8: Verify Email textbox with email value is" + emailAddress);
		registerPage.enterToEmailTextbox(emailAddress);
		
		log.info("Register - Step 9: Verify Password textbox");
		registerPage.enterToPasswordTextbox("123456");
		
		log.info("Register - Step 10: Verify Confirm password textbox");
		registerPage.enterToConfirmPasswordTextbox("123456");

		log.info("Register - Step 11: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 12: Verify success message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed.");

	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}

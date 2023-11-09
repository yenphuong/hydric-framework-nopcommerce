package com.nopcommerce.account;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;

@Epic("Account")
@Feature("Register")
public class Level_19_Allure_Report extends BaseTest {
	String browserName;
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	//private SearchPageObject searchPage;
	private String emailAddress = getEmailRandom();

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		this.browserName = browserName;
		driver = getBrowerDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Description("User 01 - Validate register form")
	@Story("register")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void User_01_Register_Validate() {
		Assert.assertTrue(homePage.isRegisterLinkDisplayed());
		
		registerPage = homePage.clickToRegisterLink();

		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");
		
		Assert.assertEquals(registerPage.getLastNameErrorMessageText(), "Last name is required.");
	}
	
	@Description("User 02 - Register Success")
	@Story("register")
	@Severity(SeverityLevel.CRITICAL )
	@Test
	public void User_02_Register_Success() {
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.enterToFirstNameTextbox("John");
		
		registerPage.enterToLastNameTextbox("Hihi");
		
		registerPage.enterToEmailTextbox(emailAddress);
		
		registerPage.enterToPasswordTextbox("123456");
		
		registerPage.enterToConfirmPasswordTextbox("123456");

		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed.");

	}


	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}

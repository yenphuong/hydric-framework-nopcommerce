package com.nopcommerce.share;

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

public class Payment extends BaseTest {
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
		
		homePage = registerPage.clickToNopCommerceLogo();

		loginPage = homePage.clickToLoginLink();

		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox("123456");

		homePage = loginPage.clickToLoginButton();

		customerPage = homePage.clickToMyAccountLink();

		Assert.assertEquals(customerPage.getFirstNameTextboxAttributeValue(), "John");
		Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(), "Hihi");
		Assert.assertEquals(customerPage.getEmailAddressTextboxAttributeValue(), emailAddress);
	}

	@Test
	public void Payment_01_Visa() {
		
	}

	@Test
	public void Payment_02_Cheque() {
		
	}
	
	@Test
	public void Payment_03_Paypal() {
		
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}

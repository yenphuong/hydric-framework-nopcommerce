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

public class Order extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private CustomerPageObject customerPage;
	private UserLoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowerDriver(browserName);
		
		homePage = PageGeneratorManager.getHomePage(driver);

		loginPage = homePage.clickToLoginLink();

		loginPage.enterToEmailTextbox(Common_Register.emailAddress);
		loginPage.enterToPasswordTextbox(Common_Register.password);

		homePage = loginPage.clickToLoginButton();

		customerPage = homePage.clickToMyAccountLink();

		Assert.assertEquals(customerPage.getFirstNameTextboxAttributeValue(), Common_Register.firstName);
		Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(), Common_Register.lastName);
		Assert.assertEquals(customerPage.getEmailAddressTextboxAttributeValue(), Common_Register.emailAddress);
		
		System.out.println("Email at Order = " + Common_Register.emailAddress);
		System.out.println("Password at Order = " + Common_Register.password);
	}

	@Test
	public void Order_01_Invalid_Address() {
		
	}

	@Test
	public void Order_02_Invalid_SSN() {
		
	}
	
	@Test
	public void Order_03_Invalid_Phone() {
		
	}
	
	@Test
	public void Order_04_Success() {
		
	}
	

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}

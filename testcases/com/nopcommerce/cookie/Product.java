package com.nopcommerce.cookie;

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

public class Product extends BaseTest {
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

		loginPage.setCookies(driver, Common_Register.cookies);
		loginPage.refreshCurrentPage(driver);
		customerPage = homePage.openMyAccountLink();

		Assert.assertEquals(customerPage.getFirstNameTextboxAttributeValue(), Common_Register.firstName);
		Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(), Common_Register.lastName);
		Assert.assertEquals(customerPage.getEmailAddressTextboxAttributeValue(), Common_Register.emailAddress);
		
		
		System.out.println("Email at Product = " + Common_Register.emailAddress);
		//System.out.println("Password at Product = " + Common_Register.password);
	}

	@Test
	public void Product_01_New_Product() {
		
	}

	@Test
	public void Product_02_View_Product() {
		
	}
	
	@Test
	public void Product_03_Edit_Product() {
		
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}

package com.nopcommerce.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.AddressPageObject;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.OrderPageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.RewardPointPageObject;
import pageObjects.user.SearchPageObject;

public class Level_12_Dynamic_Locator_Rest_Param extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private CustomerPageObject customerPage;
	private UserLoginPageObject loginPage;
	private AddressPageObject addressPage;
	private OrderPageObject orderPage;
	private RewardPointPageObject rewardPointPage;
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
		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextbox("John");
		registerPage.enterToLastNameTextbox("Hihi");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");

	}

	@Test
	public void User_02_Login_Success() {
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
	public void User_03_Switch_Page() {
		addressPage = customerPage.openAddressPage();
		
		rewardPointPage = addressPage.openRewardPointPage();
		
		customerPage = rewardPointPage.openCustomerPage();
		
		orderPage = customerPage.openOrderPage();
	}

	@Test
	public void User_04_Switch_Page() {
		customerPage = (CustomerPageObject) orderPage.openDynamicSidebarPage("Customer info");
		
		addressPage = (AddressPageObject) customerPage.openDynamicSidebarPage("Addresses");
		
		rewardPointPage = (RewardPointPageObject) addressPage.openDynamicSidebarPage("Reward points");
		
		customerPage = (CustomerPageObject) rewardPointPage.openDynamicSidebarPage("Customer info");
		
		orderPage = (OrderPageObject) customerPage.openDynamicSidebarPage("Orders");
	}
	
	@Test
	public void User_05_Switch_Page_By_Name_No_Return() {
		orderPage.openDynamicSidebarPageByName("Customer info");
		customerPage = PageGeneratorManager.getCustomerPage(driver);
		
		customerPage.openDynamicSidebarPageByName("Addresses");
		addressPage = PageGeneratorManager.getAddressPage(driver);
		
		addressPage.openDynamicSidebarPageByName("Reward points");
		rewardPointPage = PageGeneratorManager.getRewardPointPage(driver);
		
		rewardPointPage.openDynamicSidebarPageByName("Customer info");
		customerPage = PageGeneratorManager.getCustomerPage(driver);
		
		customerPage.openDynamicSidebarPageByName("Orders");
		orderPage = PageGeneratorManager.getOrderPage(driver);
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}

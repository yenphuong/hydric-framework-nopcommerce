package com.nopcommerce.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.UserLoginPageObject;

public class Level_10_Switch_Page_Url extends BaseTest {
	private WebDriver driver;
	private HomePageObject userHomePage;
	private RegisterPageObject registerPage;
	private UserLoginPageObject userLoginPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private String emailAddress = getEmailRandom();
	
	private String adminUrl, endUserUrl;

	@Parameters({"browser", "adminUrl", "endUserUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl, String endUserUrl) {
		driver = getBrowerDriver(browserName, endUserUrl);
		
		this.adminUrl = adminUrl;
		this.endUserUrl = endUserUrl;
		
		userHomePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void User_01_User_To_Admin() {
		registerPage = userHomePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextbox("John");
		registerPage.enterToLastNameTextbox("Hihi");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");
		
		userHomePage = registerPage.clickToNopCommerceLogo();

		userLoginPage = userHomePage.clickToLoginLink();


		userLoginPage.loginToUser(emailAddress, "123456");
		
		userHomePage.clickToLogoutLink();
		
		// Home page (User) -> Login page (Admin)
		
		userHomePage.openPageUrl(driver, this.adminUrl);
		
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		adminDashboardPage = adminLoginPage.loginToAdmin("admin@yourstore.com", "admin");
		
		Assert.assertTrue(adminDashboardPage.isPageLoadedSuccess(driver));
	}

	@Test
	public void User_02_Admin_To_User() {
		adminLoginPage = adminDashboardPage.clickToLogoutLink();
		
		// Login page (admin) -> home page (user)
		adminLoginPage.openPageUrl(driver, this.endUserUrl);
		userHomePage = PageGeneratorManager.getHomePage(driver);
		
		userLoginPage = userHomePage.clickToLoginLink();
		userLoginPage.loginToUser(emailAddress, "123456");
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}

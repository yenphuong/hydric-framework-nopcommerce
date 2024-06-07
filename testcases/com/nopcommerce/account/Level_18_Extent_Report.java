
package com.nopcommerce.account;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;
import reportConfig.ExtentTestManager;

public class Level_18_Extent_Report extends BaseTest {
	String browserName;
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage; // private SearchPageObject searchPage;
	private String emailAddress = getEmailRandom();

	@Parameters("browser")

	@BeforeClass
	public void beforeClass(String browserName) {
		this.browserName = browserName;
		driver = getBrowerDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void User_01_Register_Validate(Method method) {
		ExtentTestManager.startTest(method.getName() + " - " + this.browserName.toUpperCase(),
				"User_01_Register_Validate");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 1: Verify Register link displayed");
		Assert.assertTrue(homePage.isRegisterLinkDisplayed());

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 2: Click to Register link");
		registerPage = homePage.clickToRegisterLink();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 3: Click to Register button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 4: Verify error message at Firstname textbox");
		Assert.assertEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 5: Verify error message at Lastname textbox");
		Assert.assertEquals(registerPage.getLastNameErrorMessageText(), "Last name is required.");
	}

	@Test(enabled = false)
	public void User_02_Register_Success(Method method) {
		ExtentTestManager.startTest(method.getName() + " - " + this.browserName.toUpperCase(),
				"User_02_Register_Success");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 1: Verify Firstname textbox");
		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextbox("John");

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 2: Verify Lastname textbox");
		registerPage.enterToLastNameTextbox("Hihi");

		ExtentTestManager.getTest().log(Status.INFO,
				"Register - Step 3: Verify Email textbox with email value is" + emailAddress);
		registerPage.enterToEmailTextbox(emailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 4: Verify Password textbox");
		registerPage.enterToPasswordTextbox("123456");

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 5: Verify Confirm password textbox");
		registerPage.enterToConfirmPasswordTextbox("123456");

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 6: Click to Register button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 7: Verify success message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");

	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}

package com.facebook.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.HomePageObject;
import pageObjects.facebook.PageGeneratorManager;

public class Level_20_Element_Undisplayed extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowerDriver(browserName, urlValue);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Home_01_Element_Displayed() {
		homePage.clickToCreateNewAccountButton();
		
		verifyTrue(homePage.isFirstNameTextboxDisplayed());
		verifyTrue(homePage.isLastNameTextboxDisplayed());
		verifyTrue(homePage.isEmailTextboxDisplayed());
		verifyTrue(homePage.isPasswordTextboxDisplayed());
		
		homePage.enterToEmailTextbox("automationfc@gmail.com");
		
		verifyTrue(homePage.isConfirmEmailTextboxDisplayed());
	}

	@Test
	public void Home_02_Element_Undisplayed_In_HTML() {
		homePage.enterToEmailTextbox("");
		homePage.sleepInSecond(2);
		verifyFalse(homePage.isConfirmEmailTextboxDisplayed());
	}
	
	@Test
	public void Home_03_Element_Undisplayed_Not_In_HTML() {
		homePage.clickToCloseSignUpPopup();
		
		verifyTrue(homePage.isFirstNameTextboxUndisplayed());
		verifyTrue(homePage.isLastNameTextboxUndisplayed());
		verifyTrue(homePage.isEmailTextboxUndisplayed());
		verifyTrue(homePage.isPasswordTextboxUndisplayed());
		
	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}

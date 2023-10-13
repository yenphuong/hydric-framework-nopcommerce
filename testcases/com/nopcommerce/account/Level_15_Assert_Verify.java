/*
 * package com.nopcommerce.account;
 * 
 * import org.openqa.selenium.WebDriver; import
 * org.testng.annotations.AfterClass; import org.testng.annotations.BeforeClass;
 * import org.testng.annotations.Parameters; import org.testng.annotations.Test;
 * 
 * import commons.BaseTest; import commons.PageGeneratorManager; import
 * pageObjects.user.HomePageObject; import pageObjects.user.RegisterPageObject;
 * 
 * public class Level_15_Assert_Verify extends BaseTest { private WebDriver
 * driver; private HomePageObject homePage; private RegisterPageObject
 * registerPage; //private SearchPageObject searchPage; private String
 * emailAddress = getEmailRandom();
 * 
 * @Parameters("browser")
 * 
 * @BeforeClass public void beforeClass(String browserName) { driver =
 * getBrowerDriver(browserName); homePage =
 * PageGeneratorManager.getHomePage(driver); }
 * 
 * @Test public void User_01_Register_Success() { // Verify Register link
 * undisplayed --> FAILED verifyFalse(homePage.isRegisterLinkDisplayed());
 * registerPage = homePage.clickToRegisterLink();
 * 
 * registerPage.clickToRegisterButton();
 * 
 * // Verify error message at Firstname textbox --> PASSED
 * verifyEquals(registerPage.getFirstNameErrorMessageText(),
 * "First name is required.");
 * 
 * // Verify error message at Lastname textbox --> FAILED
 * verifyEquals(registerPage.getLastNameErrorMessageText(),
 * "Last name is required");
 * 
 * registerPage.enterToFirstNameTextbox("John");
 * registerPage.enterToLastNameTextbox("Hihi");
 * registerPage.enterToEmailTextbox(emailAddress);
 * registerPage.enterToPasswordTextbox("123456");
 * registerPage.enterToConfirmPasswordTextbox("123456");
 * 
 * registerPage.clickToRegisterButton();
 * 
 * // Verify success message --> FAILED
 * verifyEquals(registerPage.getRegisterSuccessMessageText(),
 * "Your registration completed.");
 * 
 * }
 * 
 * @AfterClass public void afterClass() { closeBrowser(); }
 * 
 * }
 */
package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void enterToPasswordTextbox(String passwordValue) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, passwordValue);
	}

	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

	public HomePageObject loginToUser(String emailAddress, String passwordValue) {
		enterToEmailTextbox(emailAddress);
		enterToPasswordTextbox(passwordValue);
		return clickToLoginButton();
	}
}

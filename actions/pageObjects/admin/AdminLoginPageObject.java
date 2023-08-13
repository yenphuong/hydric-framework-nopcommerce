package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageObjects.user.HomePageObject;
import pageUIs.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void enterToPasswordTextbox(String passwordValue) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, passwordValue);
	}

	public AdminDashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}

	public AdminDashboardPageObject loginToAdmin(String emailAddress, String passwordValue) {
		enterToEmailTextbox(emailAddress);
		enterToPasswordTextbox(passwordValue);
		return clickToLoginButton();
	}

}

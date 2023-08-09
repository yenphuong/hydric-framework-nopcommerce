package pageObject.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {
	WebDriver driver;

	@CacheLookup
	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstnameTextbox;

	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement lastnameTextbox;

	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextbox;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextbox;

	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTextbox;

	@FindBy(xpath = "//button[@id='register-button']")
	private WebElement registerButton;

	@FindBy(xpath = "//span[@id='FirstName-error']")
	private WebElement firstnameErrorMessage;

	@FindBy(xpath = "//span[@id='LastName-error']")
	private WebElement lastnameErrorMessage;

	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement emailErrorMessage;

	@FindBy(xpath = "//span[@id='Password-error']")
	private WebElement passwordErrorMessage;

	@FindBy(xpath = "//span[@id='ConfirmPassword-error']")
	private WebElement confirmPasswordErrorMessage;

	@FindBy(xpath = "//div[@class='result']")
	private WebElement registrationCompletedMessage;

	@FindBy(xpath = "//div[@class='header-logo']")
	private WebElement nopCommerceLogo;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getFirstNameErrorMessageText() {
		waitForElementVisible(driver, firstnameErrorMessage);
		return getElementText(driver, firstnameErrorMessage);
	}

	public String getLastNameErrorMessageText() {
		waitForElementVisible(driver, lastnameErrorMessage);
		return getElementText(driver, lastnameErrorMessage);
	}

	public String getEmailErrorMessageText() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public String getPasswordErrorMessageText() {
		waitForElementVisible(driver, passwordErrorMessage);
		return getElementText(driver, passwordErrorMessage);
	}

	public String getConfirmPasswordErrorMessageText() {
		waitForElementVisible(driver, confirmPasswordErrorMessage);
		return getElementText(driver, confirmPasswordErrorMessage);
	}

	public void clickToNopCommerceLogo() {
		waitForElementClickable(driver, nopCommerceLogo);
		clickToElement(driver, nopCommerceLogo);
	}

	public void enterToFirstNameTextbox(String firstNameValue) {
		waitForElementVisible(driver, firstnameTextbox);
		sendkeyToElement(driver, firstnameTextbox, firstNameValue);
	}

	public void enterToLastNameTextbox(String lastNameValue) {
		waitForElementVisible(driver, lastnameTextbox);
		sendkeyToElement(driver, lastnameTextbox, lastNameValue);
	}

	public void enterToEmailTextbox(String emailValue) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, emailValue);
	}

	public void enterToPasswordTextbox(String passwordValue) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, passwordValue);
	}

	public void enterToConfirmPasswordTextbox(String confirmPasswordValue) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendkeyToElement(driver, confirmPasswordTextbox, confirmPasswordValue);
	}

	public String getRegisterSuccessMessageText() {
		waitForElementVisible(driver, registrationCompletedMessage);
		return getElementText(driver, registrationCompletedMessage);
	}

}

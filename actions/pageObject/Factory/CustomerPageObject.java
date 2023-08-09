package pageObject.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class CustomerPageObject extends BasePageFactory {
	WebDriver driver;
	
	@CacheLookup
	@FindBy(xpath =  "//input[@id='FirstName']")
	private WebElement firstnameTextbox;

	@FindBy(xpath =  "//input[@id='LastName']")
	private WebElement lastnameTextbox;
	
	@FindBy(xpath =  "//input[@id='Email']")
	private WebElement emailAddressTextbox;
	
	public CustomerPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public String getFirstNameTextboxAttributeValue() {
		waitForElementVisible(driver, firstnameTextbox);
		return getElementAttribute(driver, firstnameTextbox, "value");
	}

	public String getLastNameTextboxAttributeValue() {
		waitForElementVisible(driver, lastnameTextbox);
		return getElementAttribute(driver, lastnameTextbox, "value");
	}

	public String getEmailAddressTextboxAttributeValue() {
		waitForElementVisible(driver, emailAddressTextbox);
		return getElementAttribute(driver, emailAddressTextbox, "value");
	}

}

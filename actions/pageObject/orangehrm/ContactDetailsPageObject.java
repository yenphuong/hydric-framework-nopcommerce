package pageObject.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class ContactDetailsPageObject extends BasePage {
	private WebDriver driver;
	
	public ContactDetailsPageObject(WebDriver driver) {
		this.driver = driver;
	}
}

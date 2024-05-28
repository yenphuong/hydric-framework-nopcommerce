package pageObject.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class ContactDetailsPageObject extends BasePageObjectOrangeHRM {
	WebDriver driver;
	
	public ContactDetailsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}

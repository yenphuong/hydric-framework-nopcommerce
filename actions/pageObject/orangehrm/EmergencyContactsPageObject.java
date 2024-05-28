package pageObject.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class EmergencyContactsPageObject extends BasePageObjectOrangeHRM {
	WebDriver driver;
	
	public EmergencyContactsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}

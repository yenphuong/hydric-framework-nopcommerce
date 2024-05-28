package pageObject.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class ImmigrationPageObject extends BasePageObjectOrangeHRM {
	WebDriver driver;
	
	public ImmigrationPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}

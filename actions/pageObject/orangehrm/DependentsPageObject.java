package pageObject.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class DependentsPageObject extends BasePageObjectOrangeHRM {
	WebDriver driver;
	
	public DependentsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}

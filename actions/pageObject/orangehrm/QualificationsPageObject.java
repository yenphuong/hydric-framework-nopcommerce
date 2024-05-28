package pageObject.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class QualificationsPageObject extends BasePageObjectOrangeHRM {
	WebDriver driver;
	
	public QualificationsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}

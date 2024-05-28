package pageObject.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class JobEmployeePageObject extends BasePageObjectOrangeHRM {
	WebDriver driver;
	
	public JobEmployeePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}

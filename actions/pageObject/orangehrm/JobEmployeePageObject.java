package pageObject.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class JobEmployeePageObject extends BasePage {
	private WebDriver driver;
	
	public JobEmployeePageObject(WebDriver driver) {
		this.driver = driver;
	}
}

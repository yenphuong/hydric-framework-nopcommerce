package pageObject.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class SalaryPageObject extends BasePage {
	private WebDriver driver;
	
	public SalaryPageObject(WebDriver driver) {
		this.driver = driver;
	}
}

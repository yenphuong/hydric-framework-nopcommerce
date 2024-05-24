package pageObject.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class DependentsPageObject extends BasePage {
	private WebDriver driver;
	
	public DependentsPageObject(WebDriver driver) {
		this.driver = driver;
	}
}

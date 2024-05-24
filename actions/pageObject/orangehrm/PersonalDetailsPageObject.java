package pageObject.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class PersonalDetailsPageObject extends BasePage {
	private WebDriver driver;
	
	public PersonalDetailsPageObject(WebDriver driver) {
		this.driver = driver;
	}
}

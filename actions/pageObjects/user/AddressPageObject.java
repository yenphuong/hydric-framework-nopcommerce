package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.HomePageUI;

public class AddressPageObject extends MyAccountSidebarPageObject {
	WebDriver driver;

	public AddressPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	

}

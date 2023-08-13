package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.HomePageUI;

public class OrderPageObject extends MyAccountSidebarPageObject {
	WebDriver driver;

	public OrderPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	

}

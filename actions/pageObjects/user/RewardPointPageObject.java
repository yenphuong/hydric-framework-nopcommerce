package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.HomePageUI;

public class RewardPointPageObject extends MyAccountSidebarPageObject {
	WebDriver driver;

	public RewardPointPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	

}

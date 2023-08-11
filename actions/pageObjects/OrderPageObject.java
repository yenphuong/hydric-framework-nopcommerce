package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.HomePageUI;

public class OrderPageObject extends BasePage {
	WebDriver driver;

	public OrderPageObject(WebDriver driver) {
		this.driver = driver;
	}

	

}

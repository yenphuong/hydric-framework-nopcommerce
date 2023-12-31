package pageObjects.jquery;

import org.openqa.selenium.WebDriver;

import commons.BaseTest;

public class PageGeneratorManager extends BaseTest {
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static UploadPageObject getUploadPage(WebDriver driver) {
		return new UploadPageObject(driver);
	}
}

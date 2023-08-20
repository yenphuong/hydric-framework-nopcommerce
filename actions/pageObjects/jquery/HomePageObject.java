package pageObjects.jquery;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.jquery.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchByColumnName(String columnName, String valueToSendkeys) {
		waitForElementVisible(driver, HomePageUI.SEARCH_TEXTBOX, columnName);
		sendkeyToElement(driver, HomePageUI.SEARCH_TEXTBOX, valueToSendkeys, columnName);
	}
	
	public void clickToChangePage(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGE_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGE_NUMBER, pageNumber);
	}
	
	public boolean isPageActiveByNumber(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGE_NUMBER_ACTIVE, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGE_NUMBER_ACTIVE, pageNumber);
	}
	
	public boolean isRowDisplayed(String females, String country, String males, String total) {
		waitForElementVisible(driver, HomePageUI.ROW_DATA, females, country, males, total);
		return isElementDisplayed(driver, HomePageUI.ROW_DATA, females, country, males, total);
	}
	
	public void removeOrEditARow(String country, String actionName) {
		waitForElementClickable(driver, HomePageUI.ROW_ACTION, country, actionName);
		clickToElement(driver, HomePageUI.ROW_ACTION, country, actionName);
	}
	
	
}

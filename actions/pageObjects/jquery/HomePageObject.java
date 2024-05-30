package pageObjects.jquery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import graphql.validation.rules.VariableDefaultValuesOfCorrectType;
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

	public List<String> getAllPageValuesByColumnName(String columnName) {
		
		List<String> allValues = new ArrayList<String>();
 		// Buoc 1: lay ra tat ca cac page
		List<WebElement> allPageLinks = getListWebElement(driver, HomePageUI.ALL_PAGE_LINKS);
		int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		
		
		// Buoc 2: Duyet qua tung page
		for (WebElement pageLink : allPageLinks) {
			pageLink.click();
			sleepInSecond(1);
			// Buoc 3: Lay ra tat ca cac gia tri cua 1 cot trong page do -> luu ra List/Set...
			// Buoc 4: duyet het cac page con lai
			List<WebElement> allRowValues = getListWebElement(driver, HomePageUI.ALL_VALUE_BY_COLUMN_INDEX, String.valueOf(columnIndex));
			for (WebElement rowValue : allRowValues) {
				allValues.add(rowValue.getText());
				
			}
		}
		// sort ASC/ DESC
		Collections.sort(allValues);
		return allValues;
	}public void enterToTextboxByColumnNameAndRowIndex(String columnName, String rowIndex, String valueToSend) {
		int columnIndex = getListElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		waitForElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_ROW_INDEX_AND_COLUMN_INDEX, valueToSend, rowIndex, String.valueOf(columnIndex));
		
	}

	public void selectByColumnNameAndRowIndex(String columnName, String rowIndex, String dropdownItem) {
		int columnIndex = getListElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, dropdownItem, rowIndex, String.valueOf(columnIndex));
	}

	public void clickToCheckboxByColumnNameAndRowIndex(String columnName, String rowIndex) {
		int columnIndex = getListElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		checkToElement(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
	}

}

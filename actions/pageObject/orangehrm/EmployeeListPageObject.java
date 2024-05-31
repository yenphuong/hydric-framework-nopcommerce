package pageObject.orangehrm;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstantsOrangeHRM;
import pageUIs.orangehrm.AddEmployeePageUI;
import pageUIs.orangehrm.BasePageUIOrangeHRM;
import pageUIs.orangehrm.EmployeeListPageUI;

public class EmployeeListPageObject extends BasePageObjectOrangeHRM {
	WebDriver driver;
	
	public EmployeeListPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public AddEmployeePageObject clickToAddEmployeeButton() {
		waitForElementClickable(driver, EmployeeListPageUI.ADD_EMPLOYEE_BUTTON);
		clickToElement(driver, EmployeeListPageUI.ADD_EMPLOYEE_BUTTON);
		waitForSpinnerLoadingIconInvisible();
		return PageGeneratorManager.getAddEmployeePage(driver);
	}

	public void enterToEmployeeIDTextbox(String employeeID) {
		waitForElementVisible(driver, BasePageUIOrangeHRM.EMPLOYEEID_TEXTBOX);
		sendkeyToElement(driver, BasePageUIOrangeHRM.EMPLOYEEID_TEXTBOX, employeeID);
	}
	
	public void clickToSearchButton() {
		waitForElementClickable(driver, EmployeeListPageUI.SEARCH_BUTTON);
		clickToElement(driver, EmployeeListPageUI.SEARCH_BUTTON);
	}

	public boolean isValueDisplayedAtColumnName(String columnName, String valueVerify) {
		int columnIndex = getListElementSize(driver, BasePageUIOrangeHRM.DYNAMIC_COLUMN_INDEX_BY_NAME, columnName)+1;
		waitForElementVisible(driver, BasePageUIOrangeHRM.DYNAMIC_COLUMN_VALUE_BY_NAME, columnName, String.valueOf(columnIndex), valueVerify);
		return isElementDisplayed(driver, BasePageUIOrangeHRM.DYNAMIC_COLUMN_VALUE_BY_NAME, columnName, String.valueOf(columnIndex), valueVerify);
		}

	public PersonalDetailsPageObject clickToEditIconByEmployeeID(String employeeID) {
		waitForElementClickable(driver, EmployeeListPageUI.EDIT_ICON_BY_EMPLOYEE_ID, employeeID);
		clickToElement(driver, EmployeeListPageUI.EDIT_ICON_BY_EMPLOYEE_ID, employeeID);
		waitForSpinnerLoadingIconInvisible();
		return PageGeneratorManager.getPersonalDetailsPage(driver);
	}

	
}

package pageObject.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
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

	public boolean isValueDisplayedAtColumnName(String string, String employeeID) {
		// TODO Auto-generated method stub
		return false;
	}

	
}

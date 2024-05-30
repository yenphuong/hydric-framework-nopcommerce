package pageObject.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.BasePageUIOrangeHRM;
import pageUIs.orangehrm.PersonalDetailsPageUI;

public class PersonalDetailsPageObject extends BasePageObjectOrangeHRM {
	WebDriver driver;
	
	public PersonalDetailsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getFirstnameValue() {
		waitForElementVisible(driver, BasePageUIOrangeHRM.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, BasePageUIOrangeHRM.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastnameValue() {
		waitForElementVisible(driver, BasePageUIOrangeHRM.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, BasePageUIOrangeHRM.LASTNAME_TEXTBOX, "value");
	}

	public String getEmployeeIDValue() {
		waitForElementVisible(driver, BasePageUIOrangeHRM.EMPLOYEEID_TEXTBOX);
		return getElementAttribute(driver, BasePageUIOrangeHRM.EMPLOYEEID_TEXTBOX, "value");
	}

	public EmployeeListPageObject clickToEmployeeListButton() {
		waitForElementClickable(driver, PersonalDetailsPageUI.EMPLOYEE_LIST_BUTTON);
		clickToElement(driver, PersonalDetailsPageUI.EMPLOYEE_LIST_BUTTON);
		return PageGeneratorManager.getEmployeeListPage(driver);
	}

	public boolean isPersonalDetailsHeaderDisplayed() {
		waitForElementVisible(driver, PersonalDetailsPageUI.PERSONAL_DETAILS_HEADER);
		return isElementDisplayed(driver, PersonalDetailsPageUI.PERSONAL_DETAILS_HEADER);
	}
}

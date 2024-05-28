package pageObject.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.BasePageUIOrangeHRM;

public class AddEmployeePageObject extends BasePageObjectOrangeHRM {
	WebDriver driver;
	
	public AddEmployeePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToFirstnameTextbox(String string) {
		waitForElementVisible(driver, BasePageUIOrangeHRM.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, BasePageUIOrangeHRM.FIRSTNAME_TEXTBOX, string);
	}

	public void enterToLastnameTextbox(String string) {
		waitForElementVisible(driver, BasePageUIOrangeHRM.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, BasePageUIOrangeHRM.LASTNAME_TEXTBOX, string);
	}

	public String getEmployeeID() {
		waitForElementVisible(driver, BasePageUIOrangeHRM.EMPLOYEEID_TEXTBOX);
		return getElementAttribute(driver, BasePageUIOrangeHRM.EMPLOYEEID_TEXTBOX, "value");
	}

	public void clickSaveButton() {
		waitForElementClickable(driver, BasePageUIOrangeHRM.SAVE_BUTTON);
		clickToElement(driver, BasePageUIOrangeHRM.SAVE_BUTTON);
	}

}

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

	public void enterToDriverLicenseNumberTextbox(String licenseNumber) {
		waitForElementVisible(driver, PersonalDetailsPageUI.DRIVEN_LICENSE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, PersonalDetailsPageUI.DRIVEN_LICENSE_NUMBER_TEXTBOX, licenseNumber);
	}

	public void enterToLicenseExpiryDatePicker(String licenseExpiryDate) {
		waitForElementVisible(driver, PersonalDetailsPageUI.DRIVEN_LICENSE_EXPIRY_DATE_PICKER);
		sendkeyToElement(driver, PersonalDetailsPageUI.DRIVEN_LICENSE_EXPIRY_DATE_PICKER, licenseExpiryDate);
	}

	public void enterToNationalityDropdown(String nationality) {
		waitForElementClickable(driver, PersonalDetailsPageUI.NATIONALITY_DROPDOWN_CHECKBOX_PARENT);
		selectItemInCustomDropdown(driver, PersonalDetailsPageUI.NATIONALITY_DROPDOWN_CHECKBOX_PARENT, PersonalDetailsPageUI.NATIONALITY_DROPDOWN_CHECKBOX_CHILD, nationality);
	}

	public void enterToMaritalStatusDropdown(String maritalStatus) {
		waitForElementClickable(driver, PersonalDetailsPageUI.MARITAL_STATUS_DROPDOWN_CHECKBOX_PARENT);
		selectItemInCustomDropdown(driver, PersonalDetailsPageUI.MARITAL_STATUS_DROPDOWN_CHECKBOX_PARENT, PersonalDetailsPageUI.MARITAL_STATUS_DROPDOWN_CHECKBOX_CHILD, maritalStatus);
	}

	public void enterToDateOfBirthDatePicker(String dateOfBirth) {
		waitForElementVisible(driver, PersonalDetailsPageUI.DOB_DATE_PICKER);
		sendkeyToElement(driver, PersonalDetailsPageUI.DOB_DATE_PICKER, dateOfBirth);
	}

	public String isLicenseNumberText() {
		return getElementAttribute(driver, PersonalDetailsPageUI.DRIVEN_LICENSE_NUMBER_TEXTBOX, "value");
	}

	public String isLicenseExpiryDateText() {
		return getElementAttribute(driver, PersonalDetailsPageUI.DRIVEN_LICENSE_EXPIRY_DATE_PICKER, "value");
	}
	
	public String isNationalityDropdownSelectedText() {
		return getElementText(driver, PersonalDetailsPageUI.NATIONALITY_DROPDOWN_CHECKBOX_RESULT);
	}

	public String isMaritalDropdownSelectedText() {
		return getElementText(driver, PersonalDetailsPageUI.MARITAL_STATUS_DROPDOWN_CHECKBOX_RESULT);
	}
	
	public String isDobText() {
		return getElementAttribute(driver, PersonalDetailsPageUI.DOB_DATE_PICKER, "value");
	}

	
}

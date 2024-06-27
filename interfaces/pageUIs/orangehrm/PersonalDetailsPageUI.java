package pageUIs.orangehrm;

public class PersonalDetailsPageUI {
	public static final String EMPLOYEE_LIST_BUTTON = "xpath=//a[text()='Employee List']";
	public static final String PERSONAL_DETAILS_HEADER = "xpath=//h6[text()='Personal Details']";

	public static final String DRIVEN_LICENSE_NUMBER_TEXTBOX = "xpath=//label[text()=\"Driver's License Number\"]/parent::div/following-sibling::div/input";

	public static final String DRIVEN_LICENSE_EXPIRY_DATE_PICKER = "xpath=//label[text()='License Expiry Date']/parent::div/following-sibling::div//input";
	public static final String NATIONALITY_DROPDOWN_CHECKBOX_PARENT = "xpath=//label[text()='Nationality']/parent::div/following-sibling::div";
	public static final String NATIONALITY_DROPDOWN_CHECKBOX_RESULT = "xpath=//label[text()='Nationality']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
	public static final String NATIONALITY_DROPDOWN_CHECKBOX_CHILD = "xpath=//label[text()='Nationality']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
	public static final String MARITAL_STATUS_DROPDOWN_CHECKBOX_PARENT = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div";
	public static final String MARITAL_STATUS_DROPDOWN_CHECKBOX_RESULT = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
	public static final String MARITAL_STATUS_DROPDOWN_CHECKBOX_CHILD = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span";
	public static final String DOB_DATE_PICKER = "xpath=//label[text()='Date of Birth']/parent::div/following-sibling::div//input";

}

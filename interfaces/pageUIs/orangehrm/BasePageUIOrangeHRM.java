package pageUIs.orangehrm;

public class BasePageUIOrangeHRM {
	public static final String FIRSTNAME_TEXTBOX = "css=input[name='firstName']";
	public static final String LASTNAME_TEXTBOX = "css=input[name='lastName']";
	public static final String EMPLOYEEID_TEXTBOX = "xpath=//label[text()='Employee Id']/parent::div/following-sibling::div/input";
	public static final String SAVE_BUTTON = "xpath=//button[contains(string(),'Save')]";
	public static final String DYNAMIC_CONFIRM_SUCCESSFULLY_TOAST = "xpath=//p[contains(@class, 'oxd-text--toast-message') and text()='%s']";
	public static final String SPINNER_LOADING_ICON = "css=div.oxd-loading-spinner-container";
	public static final String DYNAMIC_COLUMN_INDEX_BY_NAME = "xpath=//div[text()='%s']/preceding-sibling::div";
	public static final String DYNAMIC_COLUMN_VALUE_BY_NAME ="xpath=//div[text()='%s']/ancestor::div[@class='oxd-table-header']/following-sibling::div//div[@role='cell'][%s]/div[contains(text(),'%s')]";
}

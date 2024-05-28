package pageObject.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.BasePageUIOrangeHRM;

public class BasePageObjectOrangeHRM extends BasePage {
	private WebDriver driver;
	
	public BasePageObjectOrangeHRM(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForSpinnerLoadingIconInvisible() {
		waitForListElementInvisible(driver, BasePageUIOrangeHRM.SPINNER_LOADING_ICON);
	}

	public boolean isSuccessMessageDisplayed(String messageContent) {
		waitForElementVisible(driver, BasePageUIOrangeHRM.DYNAMIC_CONFIRM_SUCCESSFULLY_TOAST, messageContent);
		return isElementDisplayed(driver, BasePageUIOrangeHRM.DYNAMIC_CONFIRM_SUCCESSFULLY_TOAST, messageContent);
	}
}

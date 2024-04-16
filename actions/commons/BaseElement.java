package commons;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import pageObjects.user.HomePageObject;
import pageUIs.user.BaseElementUI;
import pageUIs.user.HomePageUI;
import pageUIs.user.RegisterPageUI;

public class BaseElement extends BasePage {
	WebDriver driver;

	public BaseElement(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Click to Nop Commerce Logo")
	public HomePageObject clickToNopCommerceLogo() {
		waitForElementClickable(driver, BaseElementUI.NOP_COMMERCE_LOGO);
		clickToElement(driver, BaseElementUI.NOP_COMMERCE_LOGO);
		return PageGeneratorManager.getHomePage(driver);
	}


	@Step("Click to Header Link By Name")
	public void clickToHeaderLinkByName(String pageName) {
		waitForElementClickable(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, pageName);
		clickToElement(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, pageName);
	}
	
	@Step("Click to Button by Text")
	public void clickToButtonByText(String textButton) {
		waitForElementClickable(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, textButton);
		clickToElement(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, textButton);
	}
	
	@Step("Get error messsage textbox by field's id tại bất kì page nào")
	public String getTextboxErrorMessageById(String errorId) {
		waitForElementVisible(driver,  BaseElementUI.DYNAMIC_TEXTBOX_ERROR_MSG_BY_ID, errorId);
		return getElementText(driver,  BaseElementUI.DYNAMIC_TEXTBOX_ERROR_MSG_BY_ID, errorId);
	}
	
	@Step("Nhap vafo 1 textbox bat ki tai bat ki page nao")
	public void enterToTextboxById(String textboxId, String valueToSendkey) {
		waitForElementVisible(driver,  BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, textboxId);
		sendkeyToElement(driver,  BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, valueToSendkey, textboxId);
	}
	
	@Step("lay atrribute")
	public String getTextboxAttributeById (String textboxId, String attributeName) {
		waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, textboxId);
		return getElementAttribute(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, attributeName, textboxId);
	}
}

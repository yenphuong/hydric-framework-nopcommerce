package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.BasePageUI;
import pageUIs.user.MyAccountSidebarUI;

public class MyAccountSidebarPageObject extends BasePage{
	WebDriver driver;
	
	public MyAccountSidebarPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public AddressPageObject openAddressPage(WebDriver driver) {
		waitForElementClickable(driver, MyAccountSidebarUI.ADDRESS_LINK_TEXT);
		clickToElement(driver, MyAccountSidebarUI.ADDRESS_LINK_TEXT);
		return PageGeneratorManager.getAddressPage(driver);
	}

	public OrderPageObject openOrderPage(WebDriver driver) {
		waitForElementClickable(driver, MyAccountSidebarUI.ORDER_LINK_TEXT);
		clickToElement(driver, MyAccountSidebarUI.ORDER_LINK_TEXT);
		return PageGeneratorManager.getOrderPage(driver);
	}
	
	public RewardPointPageObject openRewardPointPage(WebDriver driver) {
		waitForElementClickable(driver, MyAccountSidebarUI.REWARD_POINT_LINK_TEXT);
		clickToElement(driver, MyAccountSidebarUI.REWARD_POINT_LINK_TEXT);
		return PageGeneratorManager.getRewardPointPage(driver);
	}
	
	public CustomerPageObject openCustomerPage(WebDriver driver) {
		waitForElementClickable(driver, MyAccountSidebarUI.CUSTOMER_INFO_LINK_TEXT);
		clickToElement(driver, MyAccountSidebarUI.CUSTOMER_INFO_LINK_TEXT);
		return PageGeneratorManager.getCustomerPage(driver);
	}

}

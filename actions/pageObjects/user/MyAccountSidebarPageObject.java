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

	public AddressPageObject openAddressPage() {
		waitForElementClickable(driver, MyAccountSidebarUI.ADDRESS_LINK_TEXT);
		clickToElement(driver, MyAccountSidebarUI.ADDRESS_LINK_TEXT);
		return PageGeneratorManager.getAddressPage(driver);
	}

	public OrderPageObject openOrderPage() {
		waitForElementClickable(driver, MyAccountSidebarUI.ORDER_LINK_TEXT);
		clickToElement(driver, MyAccountSidebarUI.ORDER_LINK_TEXT);
		return PageGeneratorManager.getOrderPage(driver);
	}
	
	public RewardPointPageObject openRewardPointPage() {
		waitForElementClickable(driver, MyAccountSidebarUI.REWARD_POINT_LINK_TEXT);
		clickToElement(driver, MyAccountSidebarUI.REWARD_POINT_LINK_TEXT);
		return PageGeneratorManager.getRewardPointPage(driver);
	}
	
	public CustomerPageObject openCustomerPage() {
		waitForElementClickable(driver, MyAccountSidebarUI.CUSTOMER_INFO_LINK_TEXT);
		clickToElement(driver, MyAccountSidebarUI.CUSTOMER_INFO_LINK_TEXT);
		return PageGeneratorManager.getCustomerPage(driver);
	}
	
	public MyAccountSidebarPageObject openDynamicSidebarPage(String pageName) {
		waitForElementClickable(driver, MyAccountSidebarUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
		clickToElement(driver, MyAccountSidebarUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
		
		switch (pageName) {
		case "Customer info":
			return PageGeneratorManager.getCustomerPage(driver);
		case "Addresses":
			return PageGeneratorManager.getAddressPage(driver);
		case "Orders":
			return PageGeneratorManager.getOrderPage(driver);
		case "Reward points":
			return PageGeneratorManager.getRewardPointPage(driver);
		default:
			new RuntimeException("Sidebar page name incorrect.");
			return null;
		}
		
	}
	
	public void openDynamicSidebarPageByName(String pageName) {
		waitForElementClickable(driver, MyAccountSidebarUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
		clickToElement(driver, MyAccountSidebarUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
	}

}

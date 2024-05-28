package pageObject.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.DashboardPageUI;

public class DashboardPageObject extends BasePageObjectOrangeHRM {
	WebDriver driver;
	
	public DashboardPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public EmployeeListPageObject openPIMModule() {
		waitForElementClickable(driver, DashboardPageUI.PIM_MODULE);
		clickToElement(driver, DashboardPageUI.PIM_MODULE);
		waitForSpinnerLoadingIconInvisible();
		return PageGeneratorManager.getEmployeeListPage(driver);
	}
}

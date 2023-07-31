package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	// Toàn cục: phạm vi là ở Class
	// WebDriver driver;

	// Các hàm tương tác hầu như là void: click/ sendkeys/ accept/ cancel/ select
	// Các hàm lấy dữ liệu ra thì hầu như là String/ int WebElement/ List<WebElement>

	// 1 - Access Modifier: public/ proteceted/ private/ default
	// 2 - Kiểu dữ liệu của hàm (Data type): void/ int/ String/ boolean/ WebElement/ List<WebElement>/..
	// Nó sẽ liên quan đến cái chức năng trong thân hàm
	// 3 - Tên hàm: Đặt tên có nghĩa theo chức năng đang cần viết
	// - Convention tuân theo chuẩn của từng ngôn ngữ lập trình (Java)
	// - camelCase: từ đầu tiên viết thường - chữ cái đầu tiên của các từ tiếp theo viết hoa
	// 4 - Có tham số hay không (tùy vào chức năng cần viết)
	// 5 - Kiểu dữ liệu trả về cho hàm
	// Hoàn thành xong phần thân của hàm (trả lời cho 2/ 4/ 5)
	// - Nếu như có return dữ liệu thì sẽ khớp với kiểu dữ liệu ở số 2
	// - Nếu như có return thì nó là cái step cuối cùng

	/* Web Browser */
	public void openPageUrl(WebDriver driver, String pageUrl) {
		// Biến cục bộ, ưu tiên dùng biến cục bộ trước
		// Nếu muốn dùng biến cùng tên mà toàn cục thì dùng this chấm, ví dụ: this.driver
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		return new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
	}

	public void acceptToAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	public void cancelToAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	public String getTextInAlert(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void sendkeyToAlert(WebDriver driver, String keysToSend) {
		waitForAlertPresence(driver).sendKeys(keysToSend);
	}

	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	/* Web Element */

	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	public List<WebElement> getListWebElement(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}

	public void clickWebElement(WebDriver driver, String locator) {
		getWebElement(driver, locator).click();
		;
	}

	public void sendkeyToElement(WebDriver driver, String locator, String valueToSend) {
		getWebElement(driver, locator).clear();
		getWebElement(driver, locator).sendKeys(valueToSend);
	}

	public String getElementText(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getText();
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemValue) {
		new Select(getWebElement(driver, locator)).selectByVisibleText(itemValue);
	}

	public String getFirstSelectedTextInDefaultDropdown(WebDriver driver, String locator, String itemValue) {
		return new Select(getWebElement(driver, locator)).getFirstSelectedOption().getText();
	}
	
	public boolean isDefaultDropdownMultiple(WebDriver driver, String locator) {
		return new Select(getWebElement(driver, locator)).isMultiple();
	}
	
	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childLocator, String expectedTextItem) {
		clickWebElement(driver, parentLocator);
		sleepInSecond(1);
		List<WebElement> speedDropdownItems = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childLocator)));
		for (WebElement tempItem : speedDropdownItems) {
			if (tempItem.getText().trim().equals(expectedTextItem)) {
				sleepInSecond(1);
				tempItem.click();
				break;
			}
		}
	}
	public void enterItemInCustomDropdown(WebDriver driver, String parentLocator, String childLocator, String expectedTextItem) {
		driver.findElement(By.cssSelector(parentLocator)).clear();
		driver.findElement(By.cssSelector(parentLocator)).sendKeys(expectedTextItem);
		sleepInSecond(1);
		List<WebElement> speedDropdownItems = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
		for (WebElement item : speedDropdownItems) {
			String textActualItem = item.getText();
			if (textActualItem.equals(expectedTextItem)) {
				item.click();
			}
		}
	}
// note 
// test 2	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}

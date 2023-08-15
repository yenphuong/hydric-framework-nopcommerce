package commons;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
	// Toàn cục: phạm vi là ở Class
	// WebDriver driver;

	// Các hàm tương tác hầu như là void: click/ sendkeys/ accept/ cancel/ select
	// Các hàm lấy dữ liệu ra thì hầu như là String/ int WebElement/
	// List<WebElement>

	// 1 - Access Modifier: public/ proteceted/ private/ default
	// 2 - Kiểu dữ liệu của hàm (Data type): void/ int/ String/ boolean/ WebElement/
	// List<WebElement>/..
	// Nó sẽ liên quan đến cái chức năng trong thân hàm
	// 3 - Tên hàm: Đặt tên có nghĩa theo chức năng đang cần viết
	// - Convention tuân theo chuẩn của từng ngôn ngữ lập trình (Java)
	// - camelCase: từ đầu tiên viết thường - chữ cái đầu tiên của các từ tiếp theo
	// viết hoa
	// 4 - Có tham số hay không (tùy vào chức năng cần viết)
	// 5 - Kiểu dữ liệu trả về cho hàm
	// Hoàn thành xong phần thân của hàm (trả lời cho 2/ 4/ 5)
	// - Nếu như có return dữ liệu thì sẽ khớp với kiểu dữ liệu ở số 2
	// - Nếu như có return thì nó là cái step cuối cùng

	// Không cần khởi tạo đối tượng mà vẫn gọi được
	public static BasePage getBasePage() {
		return new BasePage();
	}

	public void openPageUrl(WebDriver driver, String pageUrl) {
		// Biến cục bộ, ưu tiên dùng biến cục bộ trước
		// Nếu muốn dùng biến cùng tên mà toàn cục thì dùng this chấm, ví dụ:
		// this.driver
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
		return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
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

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
		;
	}

	public void sendkeyToElement(WebDriver driver, WebElement element, String valueToSend) {
		element.clear();
		element.sendKeys(valueToSend);
	}

	public String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
	}
	
	public String getElementAttribute(WebDriver driver, WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}

	public void waitForElementVisible(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(15))
				.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementClickable(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(15))
				.until(ExpectedConditions.elementToBeClickable(element));
	}

	
}

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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
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
		return new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.alertIsPresent());
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

	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public By getByLocator(String locatorValue) {
		By by = null;
		if (locatorValue.startsWith("xpath=") || locatorValue.startsWith("XPath=") || locatorValue.startsWith("Xpath=")
				|| locatorValue.startsWith("XPATH=")) {
			by = By.xpath(locatorValue.substring(6));
		} else if (locatorValue.startsWith("css=") || locatorValue.startsWith("Css=")
				|| locatorValue.startsWith("CSS=")) {
			by = By.cssSelector(locatorValue.substring(4));
		} else if (locatorValue.startsWith("id=") || locatorValue.startsWith("Id=") || locatorValue.startsWith("ID=")) {
			by = By.id(locatorValue.substring(3));
		} else if (locatorValue.startsWith("name=") || locatorValue.startsWith("Name=")
				|| locatorValue.startsWith("NAME=")) {
			by = By.name(locatorValue.substring(5));
		} else if (locatorValue.startsWith("class=") || locatorValue.startsWith("Class=")
				|| locatorValue.startsWith("CLASS=")) {
			by = By.className(locatorValue.substring(6));
		} else if (locatorValue.startsWith("tagname=") || locatorValue.startsWith("Tagname=")
				|| locatorValue.startsWith("TAGNAME=")) {
			by = By.tagName(locatorValue.substring(8));
		} else {
			new RuntimeException("Locator type is not valid");
		}

		return by;
	}
	
	public String getDynamicLocator(String locator, String... restParam) {
		return String.format(locator, (Object[]) restParam);
	}
	
	public WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(getByLocator(locator));
	}
	
	public WebElement getWebElement(WebDriver driver, String locator, String... restParam) {
		return driver.findElement(getByLocator(getDynamicLocator(locator, restParam)));
	}

	public List<WebElement> getListWebElement(WebDriver driver, String locator) {
		return driver.findElements(getByLocator(locator));
	}
	
	public List<WebElement> getListWebElement(WebDriver driver, String locator, String... restParam ) {
		return driver.findElements(getByLocator(getDynamicLocator(locator, restParam)));
	}

	public void clickToElement(WebDriver driver, String locator) {
		getWebElement(driver, locator).click();
	}
	
	public void clickToElement(WebDriver driver, String locator, String... restParam) {
		getWebElement(driver, locator, restParam).click();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String valueToSend) {
		getWebElement(driver, locator).clear();
		getWebElement(driver, locator).sendKeys(valueToSend);
	}
	
	public void sendkeyToElement(WebDriver driver, String locator, String valueToSend, String... restParam) {
		getWebElement(driver, locator, restParam).clear();
		getWebElement(driver, locator, restParam).sendKeys(valueToSend);
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemValue) {
		new Select(getWebElement(driver, locator)).selectByVisibleText(itemValue);
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemValue, String... restParam) {
		new Select(getWebElement(driver, locator, restParam)).selectByVisibleText(itemValue);
	}
	
	public String getFirstSelectedTextInDefaultDropdown(WebDriver driver, String locator, String itemValue) {
		return new Select(getWebElement(driver, locator)).getFirstSelectedOption().getText();
	}
	
	public String getFirstSelectedTextInDefaultDropdown(WebDriver driver, String locator, String itemValue, String... restParam) {
		return new Select(getWebElement(driver, locator, restParam)).getFirstSelectedOption().getText();
	}

	public boolean isDefaultDropdownMultiple(WebDriver driver, String locator) {
		return new Select(getWebElement(driver, locator)).isMultiple();
	}
	
	public boolean isDefaultDropdownMultiple(WebDriver driver, String locator, String... restParam) {
		return new Select(getWebElement(driver, locator, restParam)).isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childLocator,
			String expectedTextItem) {
		getWebElement(driver, parentLocator).click();
		sleepInSecond(1);
		List<WebElement> speedDropdownItems = new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childLocator)));
		for (WebElement tempItem : speedDropdownItems) {
			if (tempItem.getText().trim().equals(expectedTextItem)) {
				sleepInSecond(1);
				tempItem.click();
				break;
			}
		}
	}

	public void enterItemInCustomDropdown(WebDriver driver, String parentLocator, String childLocator,
			String expectedTextItem) {
		getWebElement(driver, parentLocator).clear();
		sendkeyToElement(driver, parentLocator, expectedTextItem);
		sleepInSecond(1);
		List<WebElement> speedDropdownItems = new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childLocator)));
		for (WebElement tempItem : speedDropdownItems) {
			if (tempItem.getText().trim().equals(expectedTextItem)) {
				sleepInSecond(1);
				tempItem.click();
				break;
			}
		}
	}

	public String getElementText(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getText();
	}
	
	public String getElementText(WebDriver driver, String locator, String... restParam) {
		return getWebElement(driver, locator, restParam).getText();
	}

	public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		return getWebElement(driver, locator).getAttribute(attributeName);
	}

	public String getElementAttribute(WebDriver driver, String locator, String attributeName, String... restParam) {
		return getWebElement(driver, locator, restParam).getAttribute(attributeName);
	}
	
	public String getElementCssValue(WebDriver driver, String locator, String cssPropertyName) {
		return getWebElement(driver, locator).getCssValue(cssPropertyName);
	}

	public String getElementCssValue(WebDriver driver, String locator, String cssPropertyName, String... restParam) {
		return getWebElement(driver, locator, restParam).getCssValue(cssPropertyName);
	}
	
	public String convertRGBAToHexaColor(WebDriver driver, String locator) {
		return Color.fromString(getElementCssValue(driver, locator, "background-color")).asHex();
	}
	
	public String convertRGBAToHexaColor(WebDriver driver, String locator, String... restParam) {
		return Color.fromString(getElementCssValue(driver, locator, "background-color", restParam)).asHex();
	}

	public int getListElementSize(WebDriver driver, String locator) {
		return getListWebElement(driver, locator).size();
	}

	public int getListElementSize(WebDriver driver, String locator, String... restParam) {
		return getListWebElement(driver, locator, restParam).size();
	}
	
	/**
	 * Apply for checkbox and radio button
	 * 
	 * @param driver
	 * @param locator
	 */
	public void checkToElement(WebDriver driver, String locator) {
		if (!getWebElement(driver, locator).isSelected()) {
			getWebElement(driver, locator).click();
		}
	}
	
	public void checkToElement(WebDriver driver, String locator, String... restParam) {
		if (!getWebElement(driver, locator, restParam).isSelected()) {
			getWebElement(driver, locator, restParam).click();
		}
	}

	/**
	 * Only apply for checkbox
	 * 
	 * @param driver
	 * @param locator
	 */
	public void uncheckToElement(WebDriver driver, String locator) {
		if (getWebElement(driver, locator).isSelected()) {
			getWebElement(driver, locator).click();
		}
	}
	
	public void uncheckToElement(WebDriver driver, String locator, String... restParam) {
		if (getWebElement(driver, locator, restParam).isSelected()) {
			getWebElement(driver, locator, restParam).click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isSelected();
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator, String... restParam) {
		return getWebElement(driver, locator, restParam).isSelected();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isSelected();
	}
	
	public boolean isElementSelected(WebDriver driver, String locator, String... restParam) {
		return getWebElement(driver, locator, restParam).isSelected();
	}

	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isEnabled();
	}
	
	public boolean isElementEnabled(WebDriver driver, String locator, String... restParam) {
		return getWebElement(driver, locator, restParam).isEnabled();
	}

	public void switchToIframe(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getByLocator(locator)));
	}
	
	public void switchToIframe(WebDriver driver, String locator, String... restParam) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getByLocator(getDynamicLocator(locator, restParam))));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverToElement(WebDriver driver, String locator) {
		new Actions(driver).moveToElement(getWebElement(driver, locator)).perform();
	}

	public void hoverToElement(WebDriver driver, String locator, String... restParam) {
		new Actions(driver).moveToElement(getWebElement(driver, locator, restParam)).perform();
	}
	
	public void doubleClickToElement(WebDriver driver, String locator) {
		new Actions(driver).doubleClick(getWebElement(driver, locator)).perform();
	}
	
	public void doubleClickToElement(WebDriver driver, String locator, String... restParam) {
		new Actions(driver).doubleClick(getWebElement(driver, locator, restParam)).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		new Actions(driver).contextClick(getWebElement(driver, locator)).perform();
	}
	
	public void rightClickToElement(WebDriver driver, String locator, String... restParam) {
		new Actions(driver).contextClick(getWebElement(driver, locator, restParam)).perform();
	}

	/**
	 * Only for HTML4, not work for HTML5
	 * 
	 * @param driver
	 * @param sourceLocator
	 * @param targetLocator
	 */
	public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		new Actions(driver).dragAndDrop(getWebElement(driver, sourceLocator), getWebElement(driver, targetLocator))
				.perform();

	}

	public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key) {
		new Actions(driver).sendKeys(getWebElement(driver, locator), key).perform();
	}
	
	public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key, String... restParam) {
		new Actions(driver).sendKeys(getWebElement(driver, locator, restParam), key).perform();
	}

	public Object executeForBrowser(WebDriver driver, String javaScript) {
		return ((JavascriptExecutor) driver).executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		String textActual = (String) ((JavascriptExecutor) driver)
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
		sleepInSecond(3);
	}

	public void hightlightElement(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(2);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				originalStyle);
	}
	
	public void hightlightElement(WebDriver driver, String locator, String... restParam) {
		WebElement element = getWebElement(driver, locator, restParam);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(2);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, locator));
		sleepInSecond(3);
	}
	
	public void clickToElementByJS(WebDriver driver, String locator, String... restParam) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, locator, restParam));
		sleepInSecond(3);
	}

	public void scrollToElementOnTop(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				getWebElement(driver, locator));
	}
	
	public void scrollToElementOnTop(WebDriver driver, String locator, String... restParam) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				getWebElement(driver, locator, restParam));
	}

	public void scrollToElementOnDown(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);",
				getWebElement(driver, locator));
	}
	
	public void scrollToElementOnDown(WebDriver driver, String locator, String... restParam) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);",
				getWebElement(driver, locator, restParam));
	}

	public void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');",
				getWebElement(driver, locator));
	}

	public void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue, String... restParam) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');",
				getWebElement(driver, locator, restParam));
	}
	
	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, locator));
	}
	
	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove, String... restParam) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, locator, restParam));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')",
				getWebElement(driver, locator));
	}
	
	public void sendkeyToElementByJS(WebDriver driver, String locator, String value, String... restParam) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')",
				getWebElement(driver, locator, restParam));
	}

	public String getAttributeInDOM(WebDriver driver, String locator, String attributeName) {
		return (String) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].getAttribute('" + attributeName + "');", getWebElement(driver, locator));
	}
	
	public String getAttributeInDOM(WebDriver driver, String locator, String attributeName, String... restParam) {
		return (String) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].getAttribute('" + attributeName + "');", getWebElement(driver, locator));
	}

	public String getWebElementValidationMessage(WebDriver driver, String locator) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, locator));
	}
	
	public String getWebElementValidationMessage(WebDriver driver, String locator, String... restParam) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, locator, restParam));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		boolean status = (boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getWebElement(driver, locator));
		return status;
	}
	
	public boolean isImageLoaded(WebDriver driver, String locator, String... restParam) {
		boolean status = (boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getWebElement(driver, locator, restParam));
		return status;
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
		.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
	}
	
	public void waitForElementVisible(WebDriver driver, String locator, String... restParam) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(locator, restParam))));
	}

	public void waitForListElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
		.until(ExpectedConditions.visibilityOfAllElements(getListWebElement(driver, locator)));
	}
	
	public void waitForListElementVisible(WebDriver driver, String locator, String... restParam) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.visibilityOfAllElements(getListWebElement(driver, locator, restParam)));
	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
		.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locator, String... restParam) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicLocator(locator, restParam))));
	}

	public void waitForListElementInvisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
		.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locator)));
	}
	
	public void waitForListElementInvisible(WebDriver driver, String locator, String... restParam) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locator, restParam)));
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
		.until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator, String... restParam) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicLocator(locator, restParam))));
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isPageLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}
	
	
	
}

package javaBasic;

import org.openqa.selenium.By;

public class Topic_03_By {

	public By getByLocator(String locatorValue) {
		By by = null;
		if (locatorValue.startsWith("xpath=") || locatorValue.startsWith("XPath=") || locatorValue.startsWith("Xpath=")
				|| locatorValue.startsWith("XPATH=")) {
			by = By.xpath(locatorValue.substring(6));
		} else if (locatorValue.startsWith("css=") || locatorValue.startsWith("Css=")
				|| locatorValue.startsWith("CSS=")) {
			by = By.xpath(locatorValue.substring(4));
		} else if (locatorValue.startsWith("id=") || locatorValue.startsWith("Id=") || locatorValue.startsWith("ID=")) {
			by = By.xpath(locatorValue.substring(3));
		} else if (locatorValue.startsWith("name=") || locatorValue.startsWith("Name=")
				|| locatorValue.startsWith("NAME=")) {
			by = By.xpath(locatorValue.substring(5));
		} else if (locatorValue.startsWith("class=") || locatorValue.startsWith("Class=")
				|| locatorValue.startsWith("CLASS=")) {
			by = By.xpath(locatorValue.substring(6));
		} else if (locatorValue.startsWith("tagname=") || locatorValue.startsWith("Tagname=")
				|| locatorValue.startsWith("TAGNAME=")) {
			by = By.xpath(locatorValue.substring(8));
		} else {
			new RuntimeException("Locator type is not valid");
		}

		return by;
	}

}

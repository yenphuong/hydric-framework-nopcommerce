package javaBasic;

import org.testng.annotations.Test;

public class Topic_04_Rest_Parameter {
	String addressLink = "xpath=//div[@class='side-2']//a[text()='%s']";
	
	public void clickToElement(String locatorValue, String... values) {
		locatorValue  = String.format(locatorValue, (Object[]) values);
	}
	
	@Test
	public void TC_01() {
		clickToElement(addressLink, "Orders");
		
		clickToElement(addressLink, "address");
	}
}

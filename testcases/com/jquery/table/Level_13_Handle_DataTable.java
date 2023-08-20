package com.jquery.table;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;

public class Level_13_Handle_DataTable extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	String columnFemales = "Females";
	String columnCountry = "Country";
	String columnMales = "Males";
	String columnTotal = "Total";
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowerDriver(browserName, url);
		
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	
	public void User_01_Search() {
		// Search du lieu trong 1 table (Tren Header)
		homePage.searchByColumnName(columnFemales, "750");
		homePage.sleepInSecond(2);
		homePage.searchByColumnName(columnMales, "803");
		homePage.sleepInSecond(2);
		homePage.searchByColumnName(columnCountry, "Angola");
		homePage.sleepInSecond(2);
		homePage.searchByColumnName(columnTotal, "18500");
		homePage.sleepInSecond(2);
	}

	
	public void User_02_Paging() {
		homePage.clickToChangePage("10");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageActiveByNumber("10"));
		
		
		homePage.clickToChangePage("20");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageActiveByNumber("20"));
		
		homePage.clickToChangePage("6");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageActiveByNumber("6"));
		
	}
	
	@Test
	public void User_03_Verify_Element_Displayed() {
		Assert.assertTrue(homePage.isRowDisplayed("750", "Aruba", "756", "1504"));
		Assert.assertTrue(homePage.isRowDisplayed("764956", "Arab Rep of Egypt", "802948", "1567904"));
		Assert.assertTrue(homePage.isRowDisplayed("12253515", "AFRICA", "12599691", "24853148"));
	}
	
	@Test
	public void User_03_Remove_Or_Edit_A_Row() {
		homePage.removeOrEditARow("Afghanistan", "remove");
		homePage.removeOrEditARow("Algeria", "remove");
		homePage.removeOrEditARow("Antigua and Barbuda", "remove");
		homePage.removeOrEditARow("Armenia", "remove");
		
		homePage.refreshCurrentPage(driver);
		
		homePage.removeOrEditARow("Armenia", "edit");
		
		
		
	}
	
	
	
	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}

package com.jquery.table;

import java.util.ArrayList;
import java.util.List;

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
	List<String> allValuesUI = new ArrayList<String>();
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
	
	
	public void User_03_Verify_Element_Displayed() {
		Assert.assertTrue(homePage.isRowDisplayed("750", "Aruba", "756", "1504"));
		Assert.assertTrue(homePage.isRowDisplayed("764956", "Arab Rep of Egypt", "802948", "1567904"));
		Assert.assertTrue(homePage.isRowDisplayed("12253515", "AFRICA", "12599691", "24853148"));
	}
	
	
	public void User_04_Remove_Or_Edit_A_Row() {
		homePage.removeOrEditARow("Afghanistan", "remove");
		homePage.removeOrEditARow("Algeria", "remove");
		homePage.removeOrEditARow("Antigua and Barbuda", "remove");
		homePage.removeOrEditARow("Armenia", "remove");
		
		homePage.refreshCurrentPage(driver);
		
		homePage.removeOrEditARow("Armenia", "edit");
		homePage.refreshCurrentPage(driver);
	}
	
	
	public void User_05_Get_All_Column_Value() {
		// Buoc 1: lay ra tat ca cac page
		// Buoc 2: Duyet qua tung page
		// Buoc 3: Lay ra tat ca cac gia tri cua 1 cot trong page do -> luu ra List/ Set...
		// Buoc 4: duyet het cac page con lai
		
		allValuesUI = homePage.getAllPageValuesByColumnName(columnCountry);
		for (String value : allValuesUI) {
			System.out.println(value);
		}
	//	allValuesDB = homePage.getAllPageValuesByColumnNameInDB(columnCountry);
	//	Assert.assertEquals(allValuesUI, allValuesDB);
	//	homePage.getAllPageValuesByColumnName(columnTotal);
	}
	
	@Test
	public void User_06_Action_By_Index() {
		homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		
		homePage.enterToTextboxByColumnNameAndRowIndex("Contact Person", "2", "Oliver Kane");
		homePage.enterToTextboxByColumnNameAndRowIndex("Company", "1", "Omo Matic");
		
		homePage.selectByColumnNameAndRowIndex("Country", "2", "Hong Kong");
		homePage.selectByColumnNameAndRowIndex("Country", "3", "Taiwan");
	}
	
	@AfterClass
	public void afterClass() {
		//closeBrowser();
	}

}

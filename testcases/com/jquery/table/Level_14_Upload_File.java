package com.jquery.table;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.PageGeneratorManager;
import pageObjects.jquery.UploadPageObject;
import pageUIs.jquery.UploadPageUI;

public class Level_14_Upload_File extends BaseTest {
	WebDriver driver;
	UploadPageObject uploadPage;
	String locator = "";
	String dalatCity = "da_lat.jpeg";
	String hagiangCity = "ha_giang.jpeg";
	String haiphongCity = "hai_phong.jpeg";
	String[] fileNames = { dalatCity, hagiangCity, haiphongCity };

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowerDriver(browserName, url);

		uploadPage = PageGeneratorManager.getUploadPage(driver);
	}

	@Test
	public void TC_01_Upload_Single_File() {
		uploadPage.uploadMultipleFiles(driver, UploadPageUI.UPLOAD_FILE_TYPE, dalatCity);
		uploadPage.sleepInSecond(2);

		uploadPage.uploadMultipleFiles(driver, UploadPageUI.UPLOAD_FILE_TYPE, hagiangCity);
		uploadPage.sleepInSecond(2);

		uploadPage.uploadMultipleFiles(driver, UploadPageUI.UPLOAD_FILE_TYPE, haiphongCity);
		uploadPage.sleepInSecond(2);

		Assert.assertTrue(uploadPage.isFileLoadedSuccess(dalatCity));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(hagiangCity));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(haiphongCity));

		uploadPage.clickStartButtonOnEachFile();

		Assert.assertTrue(uploadPage.isFileUploadedSuccess(dalatCity));
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(hagiangCity));
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(haiphongCity));

	}

	@Test
	public void TC_02_Upload_Mutiple_Files() {
		uploadPage.refreshCurrentPage(driver);
		uploadPage.uploadMultipleFiles(driver, UploadPageUI.UPLOAD_FILE_TYPE, fileNames);
		uploadPage.sleepInSecond(2);
		
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(dalatCity));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(hagiangCity));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(haiphongCity));

		uploadPage.clickStartButtonOnEachFile();

		Assert.assertTrue(uploadPage.isFileUploadedSuccess(dalatCity));
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(hagiangCity));
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(haiphongCity));

	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}

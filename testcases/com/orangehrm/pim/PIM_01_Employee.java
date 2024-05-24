package com.orangehrm.pim;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import commons.BaseTest;
import pageObject.orangehrm.AddEmployeePageObject;
import pageObject.orangehrm.DashboardPageObject;
import pageObject.orangehrm.EmployeeListPageObject;
import pageObject.orangehrm.LoginPageObject;
import pageObject.orangehrm.PageGeneratorManager;
import pageObject.orangehrm.PersonalDetailsPageObject;
import reportConfig.ExtentTestManager;

public class PIM_01_Employee extends BaseTest {
	private WebDriver driver;
	private String browserName, employeeID;
	private LoginPageObject loginPage;
	private DashboardPageObject dashboardPage;
	private EmployeeListPageObject employeeListPage;
	private AddEmployeePageObject addEmployeePage;
	private PersonalDetailsPageObject personalDetailsPage;

	@Parameters({ "url", "browser" })
	@BeforeClass
	public void beforeClass(String url, String browserName) {
		this.browserName = browserName;
		driver = getBrowerDriver(browserName, url);
		
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		loginPage.enterToUsernameTextbox("phuonglny");
		loginPage.enterToPasswordTextbox("PhuongLNY@123");
		dashboardPage = loginPage.clickToLoginButton();
		
		employeeListPage = dashboardPage.openPIMModule();
		//a[@href="/orangehrm5/web/index.php/pim/viewPimModule"]
	}

	@Test
	public void Employee_01_Add_New(Method method) {
		ExtentTestManager.startTest(method.getName() + " - " + this.browserName.toUpperCase(),
				"Employee_01_Add_New");
		addEmployeePage = employeeListPage.clickToAddEmployeeButton();
		addEmployeePage.enterToFirstnameTextbox("");
		addEmployeePage.enterToLastnameTextbox("");
		employeeID = addEmployeePage.getEmployeeID();
		
		addEmployeePage.clickSaveButton();
		addEmployeePage.isSuccessMessageDisplayed("Successfully Saved");
		
		//p[contains(@class, 'oxd-text--toast-message') and text()='Successfully Updated'] 
	
		personalDetailsPage = PageGeneratorManager.getPersonalDetailsPage(driver);
	}

	@Test
	public void Employee_02_Personal_Details(Method method) {
		ExtentTestManager.startTest(method.getName() + " - " + this.browserName.toUpperCase(),
				"Employee_02_Personal_Details");
	}

	@Test
	public void Employee_03_Contact_Details(Method method) {
		ExtentTestManager.startTest(method.getName() + " - " + this.browserName.toUpperCase(),
				"Employee_03_Contact_Details");
	}

	@Test
	public void Employee_04_Emergency_Contacts(Method method) {
		ExtentTestManager.startTest(method.getName() + " - " + this.browserName.toUpperCase(),
				"Employee_04_Emergency_Contacts");
	}

	@Test
	public void Employee_05_Dependents(Method method) {
		ExtentTestManager.startTest(method.getName() + " - " + this.browserName.toUpperCase(),
				"Employee_05_Dependents");
	}

	@Test
	public void Employee_06_Immigration(Method method) {
		ExtentTestManager.startTest(method.getName() + " - " + this.browserName.toUpperCase(),
				"Employee_06_Immigration");
	}

	@Test
	public void Employee_07_Job(Method method) {
		ExtentTestManager.startTest(method.getName() + " - " + this.browserName.toUpperCase(),
				"Employee_07_Job");
	}

	@Test
	public void Employee_08_Salary(Method method) {
		ExtentTestManager.startTest(method.getName() + " - " + this.browserName.toUpperCase(),
				"Employee_08_Salary");
	}

	@Test
	public void Employee_09_Report_To(Method method) {
		ExtentTestManager.startTest(method.getName() + " - " + this.browserName.toUpperCase(),
				"Employee_09_Report_To");
	}

	@Test
	public void Employee_10_Qualifications(Method method) {
		ExtentTestManager.startTest(method.getName() + " - " + this.browserName.toUpperCase(),
				"Employee_10_Qualifications");
	}

	@AfterClass(alwaysRun=true)
	public void afterClass() {
		closeBrowser();
	}

}
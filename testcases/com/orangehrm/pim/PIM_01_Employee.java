package com.orangehrm.pim;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import commons.BaseTest;
import commons.GlobalConstantsOrangeHRM;
import pageObject.orangehrm.AddEmployeePageObject;
import pageObject.orangehrm.DashboardPageObject;
import pageObject.orangehrm.EmployeeListPageObject;
import pageObject.orangehrm.LoginPageObject;
import pageObject.orangehrm.PageGeneratorManager;
import pageObject.orangehrm.PersonalDetailsPageObject;
import reportConfig.ExtentTestManager;

public class PIM_01_Employee extends BaseTest {
	private WebDriver driver;
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
		firstNameUser = "Yen";
		lastNameUser = "Phuong";	
		licenseNumber = "D83772430"; 
		licenseExpiryDate = "2024-05-14"; 
		nationality = "American"; 
		maritalStatus = "Married";
		dateOfBirth = "1980-04-15";
		gender = "Male";
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		loginPage.enterToUsernameTextbox(GlobalConstantsOrangeHRM.DEV_ADMIN_USERNAME);
		loginPage.enterToPasswordTextbox(GlobalConstantsOrangeHRM.DEV_ADMIN_PASSWORD);
		dashboardPage = loginPage.clickToLoginButton();
		
		employeeListPage = dashboardPage.openPIMModule();
		//a[@href="/orangehrm5/web/index.php/pim/viewPimModule"]
	}

	@Test
	public void Employee_01_Add_New(Method method) {
		ExtentTestManager.startTest(method.getName() + " - " + this.browserName.toUpperCase(),
				"Employee_01_Add_New");
		addEmployeePage = employeeListPage.clickToAddEmployeeButton();
		addEmployeePage.enterToFirstnameTextbox(firstNameUser);
		addEmployeePage.enterToLastnameTextbox(lastNameUser);
		employeeID = addEmployeePage.getEmployeeID();
		
		addEmployeePage.clickSaveButton();
		
		addEmployeePage.isSuccessMessageDisplayed("Successfully Saved");
		addEmployeePage.waitForSpinnerLoadingIconInvisible();
		
		personalDetailsPage = PageGeneratorManager.getPersonalDetailsPage(driver);
		
		personalDetailsPage.isPersonalDetailsHeaderDisplayed();
		personalDetailsPage.waitForSpinnerLoadingIconInvisible();
		
		Assert.assertEquals(personalDetailsPage.getFirstnameValue(), firstNameUser);
		Assert.assertEquals(personalDetailsPage.getLastnameValue(), lastNameUser);
		Assert.assertEquals(personalDetailsPage.getEmployeeIDValue(), employeeID);
		
		employeeListPage = personalDetailsPage.clickToEmployeeListButton();
		employeeListPage.waitForSpinnerLoadingIconInvisible();
		
		employeeListPage.enterToEmployeeIDTextbox(employeeID);
		employeeListPage.clickToSearchButton();
		employeeListPage.waitForSpinnerLoadingIconInvisible();
		
		Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("Id", employeeID));
		Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("First (& Middle) Name", firstNameUser));
		Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("Last Name", lastNameUser));
	}

	@Test
	public void Employee_02_Personal_Details(Method method) {
		ExtentTestManager.startTest(method.getName() + " - " + this.browserName.toUpperCase(),
				"Employee_02_Personal_Details");
		
		employeeListPage.clickToEditIconByEmployeeID(employeeID);	
		
		assertTrue(personalDetailsPage.isPersonalDetailsHeaderDisplayed());
		
		Assert.assertEquals(personalDetailsPage.getFirstnameValue(), firstNameUser);
		Assert.assertEquals(personalDetailsPage.getLastnameValue(), lastNameUser);
		Assert.assertEquals(personalDetailsPage.getEmployeeIDValue(), employeeID);
		
		//personalDetailsPage.enterToNicknameTextbox("");
		
		personalDetailsPage.enterToDriverLicenseNumberTextbox("");
		personalDetailsPage.enterToLicenseExpiryDatePicker("");
		personalDetailsPage.enterToNationalityDropdown("");
		personalDetailsPage.enterToMaritalStatusDropdown("");
		personalDetailsPage.enterToDateOfBirthDatePicker("");
		personalDetailsPage.enterToRadioButtonByLabelName("");
		
		personalDetailsPage.clickToSaveButtonAtPersonalDetailPart();
		
		
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


	private String browserName, employeeID, firstNameUser, lastNameUser;
	private String licenseNumber, licenseExpiryDate, nationality, maritalStatus, dateOfBirth, gender;

}

package commons;

import java.io.File;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	//protected final Logger log;
	private WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	public BaseTest() {
		//log = LogManager.getLogger(getClass());
	}

	protected WebDriver getBrowerDriver(String browserName) {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

		switch (browser) {
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case CHROME:
			driver = new ChromeDriver();
			break;
		case EDGE:
			driver = new EdgeDriver();
			break;
		case SAFARI:
			driver = new SafariDriver();
			break;
		default:
			throw new RuntimeException("Browser's name is not valid.");
		}

		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(1440, 990));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demo.nopcommerce.com/");
		return driver;
	}
	
	protected WebDriver getBrowerDriver(String browserName, String url) {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

		switch (browser) {
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case CHROME:
			ChromeOptions options = new ChromeOptions(); 
			options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
			driver = new ChromeDriver(options);
			break;
		case EDGE:
			driver = new EdgeDriver();
			break;
		case SAFARI:
			driver = new SafariDriver();
			break;
		default:
			throw new RuntimeException("Browser's name is not valid.");
		}

		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(1440, 990));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		return driver;
	}


	protected String getEmailRandom() {
		Random rand = new Random();
		return "john" + rand.nextInt(99999) + "@hihi.com";
	}

	protected void closeBrowser() {
		if (driver == null) {
			System.out.println("Browser is closed.");
		} else {
			driver.quit();
		}
	}
	
	/*
	 * protected boolean verifyTrue(boolean condition) { boolean pass = true; try {
	 * Assert.assertTrue(condition);
	 * log.info("------------------- PASSED -------------------"); } catch
	 * (Throwable e) { log.info("------------------- FAILED -------------------");
	 * pass = false; VerificationFailures.getFailures().addFailureForTest(Reporter.
	 * getCurrentTestResult(), e); Reporter.getCurrentTestResult().setThrowable(e);
	 * } return pass; }
	 * 
	 * protected boolean verifyFalse(boolean condition) { boolean pass = true; try {
	 * Assert.assertFalse(condition);
	 * log.info("------------------- PASSED -------------------"); } catch
	 * (Throwable e) { log.info("------------------- FAILED -------------------");
	 * pass = false; VerificationFailures.getFailures().addFailureForTest(Reporter.
	 * getCurrentTestResult(), e); Reporter.getCurrentTestResult().setThrowable(e);
	 * } return pass; }
	 * 
	 * protected boolean verifyEquals(Object actual, Object expected) { boolean pass
	 * = true; try { Assert.assertEquals(actual, expected);
	 * log.info("------------------- PASSED -------------------"); } catch
	 * (Throwable e) { log.info("------------------- FAILED -------------------");
	 * pass = false; VerificationFailures.getFailures().addFailureForTest(Reporter.
	 * getCurrentTestResult(), e); Reporter.getCurrentTestResult().setThrowable(e);
	 * } return pass; }
	 */ 
	@BeforeSuite 
	public void deleteFileReport() {
		deleteAllFileInFolder("reportNGScreenshot"); 
		deleteAllFileInFolder("allure-json"); 
    }
	
	
	public void deleteAllFileInFolder(String folderName) {
		try {
			String pathFolderDownload = GlobalConstants.RELATIVE_PROJECT_PATH + File.separator + folderName;
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
}

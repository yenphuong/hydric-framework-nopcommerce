package commons;

import java.time.Duration;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class BaseTest {
	protected final Logger log;
	private WebDriver driver;
	
	public BaseTest() {
		log = LogManager.getLogger(getClass());
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
	
	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
			log.info("------------------- PASSED -------------------");
		} catch (Throwable e) {
			log.info("------------------- FAILED -------------------");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
			log.info("------------------- PASSED -------------------");
		} catch (Throwable e) {
			log.info("------------------- FAILED -------------------");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info("------------------- PASSED -------------------");
		} catch (Throwable e) {
			log.info("------------------- FAILED -------------------");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

}

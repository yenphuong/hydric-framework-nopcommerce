package commons;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.LogManager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriverLogLevel;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;

public class BaseTest {
	protected final Logger log;
	private WebDriver driver;
	private Path path;
	private File extensionFilePath;

	public WebDriver getDriver() {
		return driver;
	}

	public BaseTest() {
		log = Logger.getLogger(getClass());
	}

	protected WebDriver getBrowerDriver(String browserName) {
		path = null;
		extensionFilePath = null;

		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

		// Selenium Manager (4.6 tro len)
		switch (browser) {
		/*
		 * case FIREFOX: driver = new FirefoxDriver(); break; case CHROME: driver = new
		 * ChromeDriver(); break; case EDGE: driver = new EdgeDriver(); break; case
		 * SAFARI: driver = new SafariDriver(); break;
		 */

		// Demo Localization, disable notifications popup
		case FIREFOX:
			FirefoxOptions fOptions = new FirefoxOptions();
			driver = new FirefoxDriver(fOptions);
			fOptions.addArguments("-private");
			fOptions.addPreference("geo.enabled", false);
			fOptions.addPreference("geo.provider.use_corelocation", false);
			fOptions.addPreference("intl.accept_languages", "vi-vn, vi");
			break;
		case CHROME:
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("autofill.profile_enabled", false);
			prefs.put("autofill.credit_card_enabled", false);
			prefs.put("profile.default_content_settings.popups", 0);
			prefs.put("download.default_directory", GlobalConstants.DOWNLOAD_PATH);
			
			ChromeOptions cOptions = new ChromeOptions();
			cOptions.setExperimentalOption("useAutomationExtension", false);
			cOptions.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));
			cOptions.setExperimentalOption("prefs", prefs);
			//cOptions.addArguments("--remote-debugging-pipe");
			cOptions.addArguments("--user-data-dir=/Users/lap14153/Library/Application Support/Google/Chrome/");
			cOptions.addArguments("--profile-directory=Default");
			//cOptions.addArguments("--incognito");
			cOptions.addArguments("--lang=vi");
			cOptions.addArguments("--disable-notifications");
			cOptions.addArguments("--disable-geolocation");
			driver = new ChromeDriver(cOptions);
			break;
		case EDGE:
			EdgeOptions eOptions = new EdgeOptions();
			eOptions.addArguments("--inprivate");
			eOptions.addArguments("--lang=vi");
			eOptions.addArguments("--disable-notifications");
			driver = new EdgeDriver(eOptions);
			break;
		
			
			
			
			
		// Demo log level

		/*
		 * case FIREFOX_DEMO_LOG_LEVEL:
		 * System.setProperty(GeckoDriverService.GECKO_DRIVER_LOG_PROPERTY,
		 * GlobalConstants.BROWSER_LOGS + "FirefoxPropertyLog.log");
		 * FirefoxDriverService fService = new GeckoDriverService.Builder()
		 * .withLogLevel(FirefoxDriverLogLevel.DEBUG).build(); driver = new
		 * FirefoxDriver(fService); break; case CHROME_DEMO_LOG_LEVEL:
		 * System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY,
		 * GlobalConstants.BROWSER_LOGS + "ChromePropertyLog.log"); ChromeDriverService
		 * cService = new ChromeDriverService.Builder()
		 * .withLogLevel(ChromiumDriverLogLevel.INFO).build(); driver = new
		 * ChromeDriver(cService); break; case EDGE_DEMO_LOG_LEVEL:
		 * System.setProperty(EdgeDriverService.EDGE_DRIVER_LOG_PROPERTY,
		 * GlobalConstants.BROWSER_LOGS + "EdgePropertyLog.log"); EdgeDriverService
		 * eService = new EdgeDriverService.Builder()
		 * .withLoglevel(ChromiumDriverLogLevel.DEBUG).build(); driver = new
		 * EdgeDriver(eService); break;
		 */
			
		// Demo Browser Driver Log to Console
		/*
		 * case FIREFOX_LOG_CONSOLE: FirefoxDriverService fService = new
		 * GeckoDriverService.Builder().withLogOutput(System.out).build(); driver = new
		 * FirefoxDriver(fService); break; case CHROME_LOG_CONSOLE: ChromeDriverService
		 * cService = new
		 * ChromeDriverService.Builder().withLogOutput(System.out).build(); driver = new
		 * ChromeDriver(cService); break; case EDGE_LOG_CONSOLE: EdgeDriverService
		 * eService = new EdgeDriverService.Builder().withLogOutput(System.out).build();
		 * driver = new EdgeDriver(eService); break;
		 */

		// Demo Browser Driver Log to File

		/*
		 * case FIREFOX_DEMO_LOG: FirefoxDriverService fService = new
		 * GeckoDriverService.Builder() .withLogFile(new
		 * File(GlobalConstants.BROWSER_LOGS + "FirefoxLog.log")).build(); driver = new
		 * FirefoxDriver(fService); break; case CHROME_DEMO_LOG: ChromeDriverService
		 * cService = new ChromeDriverService.Builder() .withLogFile(new
		 * File(GlobalConstants.BROWSER_LOGS + "ChromeLog.log")).build(); driver = new
		 * ChromeDriver(cService); break; case EDGE_DEMO_LOG: EdgeDriverService eService
		 * = new EdgeDriverService.Builder() .withLogFile(new
		 * File(GlobalConstants.BROWSER_LOGS + "EdgeLog.log")).build(); driver = new
		 * EdgeDriver(eService); break;
		 */

		// Demo add extensions
		/*
		 * case FIREFOX_ADDEX: driver = new FirefoxDriver(); Path xpiPath =
		 * Paths.get(GlobalConstants.BROWSER_EXTENSIONS+"wappalyzer.xpi"); FirefoxDriver
		 * ffDriver = (FirefoxDriver) driver; ffDriver.installExtension(xpiPath); driver
		 * = ffDriver; break;
		 * 
		 * case CHROME_ADDEX: ChromeOptions options = new ChromeOptions(); path =
		 * Paths.get(GlobalConstants.BROWSER_EXTENSIONS+"wappalyzer.crx");
		 * extensionFilePath = new File(path.toUri());
		 * options.addExtensions(extensionFilePath); driver = new ChromeDriver(options);
		 * break;
		 * 
		 * case EDGE_ADDEX: EdgeOptions edgeOptions = new EdgeOptions(); path =
		 * Paths.get(GlobalConstants.BROWSER_EXTENSIONS+"wappalyzer.crx");
		 * extensionFilePath = new File(path.toUri());
		 * edgeOptions.addExtensions(extensionFilePath); driver = new
		 * EdgeDriver(edgeOptions); break;
		 */

		// Demo run Headless
		/*
		 * case FIREFOX_HEADLESS: FirefoxOptions firefoxOptions = new FirefoxOptions();
		 * firefoxOptions.addArguments("--headless");
		 * firefoxOptions.addArguments("window-size=1366x768"); driver = new
		 * FirefoxDriver(firefoxOptions); break;
		 * 
		 * case CHROME_HEADLESS: ChromeOptions chromeOptions = new ChromeOptions();
		 * chromeOptions.addArguments("--headless");
		 * chromeOptions.addArguments("window-size=1366x768"); driver = new
		 * ChromeDriver(chromeOptions); break; case EDGE_HEADLESS: EdgeOptions
		 * edgeOptions = new EdgeOptions(); edgeOptions.addArguments("--headless");
		 * edgeOptions.addArguments("window-size=1366x768"); driver = new
		 * EdgeDriver(edgeOptions); break;
		 */

		default:
			throw new RuntimeException("Browser's name is not valid.");
		}

		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(1440, 990));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
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
			options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
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

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
		driver.get(url);
		return driver;
	}

	protected String getEmailRandom() {
		Random rand = new Random();
		return "john" + rand.nextInt(99999) + "@hihi.com";
	}

	protected void closeBrowser() {
		// Tao ra 1 bien cmd = null
		String cmd = null;
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI \'IMAGENAME eq " + browserDriverName + "*\'";
			} else {
				cmd = "pkill " + browserDriverName;
			}

			// log.info("Command = " + cmd);

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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
			if (listOfFiles.length != 0) {
				for (int i = 0; i < listOfFiles.length; i++) {
					if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
						new File(listOfFiles[i].toString()).delete();
					}
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

}

package util;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Utils {

	public static WebDriver driver = null;

	public static WebDriver openBrowser(int iTestCaseRow) throws Exception {

		String sBrowserName;

		try {
			sBrowserName = ExcelUtils.getCellData(iTestCaseRow,
					Constants.Col_Browser);

			if (sBrowserName.equals("Phantom")) {
				if (Boolean.valueOf(Constants.getProps().getProperty("UsePhantomJS"))) {
					DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
					driver = new PhantomJSDriver(capabilities);
				} else{
					DesiredCapabilities capabilities = DesiredCapabilities.chrome();
					System.setProperty("webdriver.chrome.driver", "./chromedriver");
					driver = new ChromeDriver(capabilities);

					driver.manage().window().maximize();
					Log.info("New driver instantiated");
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					Log.info("Implicit wait applied on the driver for 10 seconds");
					driver.get(Constants.URL);
					Log.info("Web application launched successfully");
				}
			}else if(sBrowserName.equals("Chrome")){
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				System.setProperty("webdriver.chrome.driver", "./chromedriver");
				driver = new ChromeDriver(capabilities);

				driver.manage().window().maximize();
				Log.info("New driver instantiated");
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				Log.info("Implicit wait applied on the driver for 10 seconds");
				driver.get(Constants.URL);
				Log.info("Web application launched successfully");
			}
			else{
				Log.error("Informed browser does not exists");
			}

		} catch (Exception e) {
			Log.error("Class Utils | Method OpenBrowser | Exception desc : "
					+ e.getMessage());
		}
		return driver;
	}

	public static String getTestCaseName(String sTestCase) throws Exception {

		String value = sTestCase;

		try {

			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");
			value = value.substring(posi + 1);
			return value;
		} catch (Exception e) {

			Log.error("Class Utils | Method getTestCaseName | Exception desc : "
					+ e.getMessage());
			throw (e);
		}

	}

	public static int getRowContains(String sTestCaseName, int colNum)
			throws Exception {

		int i;

		try {

			int rowCount = ExcelUtils.getRowUsed();
			for (i = 0; i < rowCount; i++) {
				if (ExcelUtils.getCellData(i, colNum).equalsIgnoreCase(sTestCaseName)) {
					break;
				}
			}

			return i;
		} catch (Exception e) {

			Log.error("Class ExcelUtil | Method getRowContains | Exception desc : " + e.getMessage());
			throw (e);
		}
	}

	public static void configureTest(String fileName) throws Exception {

		DOMConfigurator.configure("log4j.xml");
		ExcelUtils.setExcelFile(Constants.Path_TestData + fileName, "Sheet 1");
	}

	public static void configureTest() throws Exception {

		DOMConfigurator.configure("log4j.xml");
	}

	public static void waitForElement(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void takeScreenshot(WebDriver driver, String sTestCaseName)
			throws Exception {

		try {
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(Constants.Path_ScreenShot
					+ sTestCaseName + ".jpg"));
		} catch (Exception e) {
			Log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "
					+ e.getMessage());
			throw new Exception();
		}
	}

	public static String generateRandomNumber() {

		Random r = new Random();
		int randomNumb = r.nextInt();
		if (randomNumb < 0) {
			randomNumb = randomNumb * (-1);
		}

		return String.valueOf(randomNumb);
	}
}
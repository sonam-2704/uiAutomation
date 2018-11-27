package com.cleartrip.testBase;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import com.cleartrip.util.Utility;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Component
public class TestBase {

	Utility utility;
	Properties prop;
	public static WebDriver driver;
	public Scenario scenario;

	/**
	 * Method to select browser type and initialize driver
	 *
	 */

	public void selectBrowser() {

		utility = new Utility();
		prop = utility.getProperties();
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {

			// Create object of HashMap Class
			Map<String, Object> prefs = new HashMap<String, Object>();

			// Set the notification setting it will override the default setting
			prefs.put("profile.default_content_setting_values.notifications", 2);

			// Create object of ChromeOption class
			ChromeOptions options = new ChromeOptions();

			// Set the experimental option
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("disable-infobars");
			
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();

		}
	}

	/**
	 * Method to launch application
	 *
	 */

	public void openApp() {

		driver.get(prop.getProperty("url"));
	}

	/**
	 * Method to get value from config.properties file for specific key
	 *
	 */

	public String getValueFromProperiesFile(String key) {

		utility = new Utility();
		prop = utility.getProperties();

		return prop.getProperty(key);

	}

	/**
	 * Method to return Response object for API validation
	 *
	 */

	protected Response apiInitialSetUp() {

		String baseUrl = getValueFromProperiesFile("baseUrl");
		String methodUrl = getValueFromProperiesFile("methodUrl");

		RestAssured.baseURI = baseUrl;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, methodUrl);

		return response;
	}

	/**
	 * Method for Explicit Wait for element till element visible on screen
	 *
	 */

	protected void waitForVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Method to take screenshot
	 *
	 */

	protected void takeScreenShot(String methodName) throws IOException {
		File file = new File("testresults");
		file.getAbsolutePath();
		String screenShotName = methodName + ".png";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File desFile = new File("./testresults/" + screenShotName);
		FileUtils.copyFile(scrFile, desFile);
	}

	/**
	 * Method to close browser
	 *
	 */

	protected void tearDown() {

		driver.quit();
	}

}

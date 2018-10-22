package com.cleartrip.testBase;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import com.cleartrip.util.Utility;

import cucumber.api.Scenario;

@Component
public class TestBase {

	Utility utility;
	Properties prop;
	public static WebDriver driver;
	public Scenario scenario;

	public void selectBrowser() {

		utility = new Utility();
		init();
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		}
	}

	public void openApp() {

		System.out.println("==============");
		System.out.println(driver);
		driver.get(prop.getProperty("url"));
	}

	public void init() {
		prop = utility.getProperties();
	}

	// Explicit Wait for element till element visible on screen
	protected void waitForVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Get screenshot method
	protected void takeScreenShot(String methodName) throws IOException {
		File file = new File("testresults");
		file.getAbsolutePath();
		String screenShotName = methodName + ".png";
		System.out.println("Diriver before screenshot:--" + driver);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File desFile = new File("./testresults/" + screenShotName);
		FileUtils.copyFile(scrFile, desFile);
	}

	protected void tearDown() {

		System.out.println("driver: " + driver);
		driver.quit();
	}

}

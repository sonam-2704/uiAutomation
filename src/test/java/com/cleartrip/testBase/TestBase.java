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

	public void selectBrowser() {

		utility = new Utility();
		prop = utility.getProperties();
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		}
	}

	public void openApp() {

		driver.get(prop.getProperty("url"));
	}

	public String getValueFromProperiesFile(String key){
		
		utility = new Utility();
		prop = utility.getProperties();
		
		return prop.getProperty(key);
		
	}
	
	protected Response  apiInitialSetUp(){
		

		String baseUrl = getValueFromProperiesFile("baseUrl");
		String methodUrl = getValueFromProperiesFile("methodUrl");
		
		RestAssured.baseURI = baseUrl;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, methodUrl);
		
		return response;
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
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File desFile = new File("./testresults/" + screenShotName);
		FileUtils.copyFile(scrFile, desFile);
	}

	protected void tearDown() {

		driver.quit();
	}
	
	

}

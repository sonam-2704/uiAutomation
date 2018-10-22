/**
 * 
 */
package com.cleartrip.pageobjects;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;
import com.cleartrip.testBase.TestBase;

/**
 * @author Sonam_Mittal
 *
 */

@Component("searchFlightPage")
public class SearchFlightPage extends TestBase{

	private  static Logger logger = Logger.getLogger(SearchFlightPage.class);
	

	@FindBy(xpath ="//input[@id='SearchBtn']")
	public WebElement searchButton;

	@FindBy(xpath = "//h1[contains(text(),'Search flights')]")
	public WebElement searchFlightHeader;

	@FindBy(id="OneWay")
	WebElement oneWayButton;

	@FindBy(id="RoundTrip")
	WebElement roundTripButton;

	@FindBy(id="MultiCity")
	WebElement multiCityButton;

	@FindBy(xpath ="//input[@title='Any worldwide city or airport'][@id='FromTag']")
	public WebElement fromField;

	@FindBy(xpath ="//input[@title='Any worldwide city or airport'][@id='ToTag']")
	public WebElement toField;

	@FindBy(xpath ="//input[@title='Depart date']")
	public WebElement departOnDate;

	@FindBy(xpath ="//input[@title='Return date']")
	public WebElement returnDate;

	@FindBy(xpath ="//select[@id='Adults']")
	public WebElement adultDropDown;

	@FindBy(xpath ="//select[@id='Childrens']")
	public WebElement childrenDropDown;

	@FindBy(xpath ="//select[@id='Infants']")
	public WebElement infantsDropDown;

	/*public SearchFlightPage(WebDriver driver){

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}*/


	public void initializePage(WebDriver driver){

		PageFactory.initElements(driver, SearchFlightPage.class);
	}

	public void verifySearchPage(){
		assertTrue(searchFlightHeader.isDisplayed());
		logger.info("user is on search flight page");

	}

	public void selectButton(String buttonName){

		System.out.println("buttonName: "+buttonName);
		if (buttonName.equalsIgnoreCase("Search")) {
			assertTrue(searchButton.isEnabled());
			searchButton.click();
		}
		else if(buttonName.equalsIgnoreCase("One Way")){
			assertTrue(oneWayButton.isEnabled());
			oneWayButton.click();
		}
		else if(buttonName.equalsIgnoreCase("Round Trip")){
			assertTrue(roundTripButton.isEnabled());
			roundTripButton.click();
		}

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterLocation(String location,String locationValue){

		System.out.println(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		if(location.equalsIgnoreCase("From")){

			Actions act = new Actions(driver);
			waitForVisible(fromField);
			fromField.clear();
			fromField.sendKeys(locationValue);
			act.sendKeys(Keys.ARROW_DOWN).build().perform();

			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else if(location.equalsIgnoreCase("To")){

			Actions act = new Actions(driver);
			waitForVisible(toField);
			toField.clear();
			toField.sendKeys(locationValue);
			act.sendKeys(Keys.ARROW_DOWN).build().perform();

			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void selectDateFromCalendar(String dateType , String dateValue){

		if(dateType.equalsIgnoreCase("depart on")){
			waitForVisible(departOnDate);
			assertTrue(departOnDate.isDisplayed());
			departOnDate.clear();
			departOnDate.sendKeys(dateValue);
		}else{
			waitForVisible(returnDate);
			assertTrue(returnDate.isDisplayed());
			returnDate.clear();
			returnDate.sendKeys(dateValue);
		}
		searchFlightHeader.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void selectValueFromDropDown(String dropdownType,String dropdownValue){

		System.out.println("dropdownType : "+dropdownType);

		System.out.println("dropdownValue : "+dropdownValue);

		if(dropdownType.equalsIgnoreCase("Adults")){

			Select select = new Select(adultDropDown);

			select.selectByValue(dropdownValue);


		}
		else if(dropdownType.equalsIgnoreCase("Children")){

			Select select = new Select(childrenDropDown);

			select.selectByValue(dropdownValue);


		}
		else if(dropdownType.equalsIgnoreCase("Infants")){

			Select select = new Select(infantsDropDown);

			select.selectByValue(dropdownValue);


		}
	}

}

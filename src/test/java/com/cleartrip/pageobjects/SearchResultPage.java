/**
 * 
 */
package com.cleartrip.pageobjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

/**
 * @author Sonam_Mittal
 *
 */

@Component
public class SearchResultPage {

	private final static Logger logger = Logger.getLogger(SearchResultPage.class);

	@FindBy(xpath = "//*[contains(@class,'listItem')]")
	public List<WebElement>  listOfFlights;

	@FindBy(xpath = "//button[@class='booking fRight']")
	public WebElement bookButton;

	/**
	 * Method to verify list of flights on result page
	 *
	 */
	public void verifyListOfFlight() {
		Assert.assertThat(listOfFlights.size(), Matchers.greaterThan(0));
	}

	/**
	 * Method to initialize page elements
	 *
	 */
	
	public void initializePage(WebDriver driver){

		PageFactory.initElements(driver, this);
	}
	
}

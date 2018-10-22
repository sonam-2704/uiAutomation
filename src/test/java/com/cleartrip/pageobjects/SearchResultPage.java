/**
 * 
 */
package com.cleartrip.pageobjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import com.cleartrip.helper.LoggerHelper;

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


	public void verifyListOfFlight() {
		//logger.info("list of flights:::"+listOfFlights.size());
		System.out.println(listOfFlights.size());
		Assert.assertThat(listOfFlights.size(), Matchers.greaterThan(0));
	}

}

package com.cleartrip.stepdefinitions;

import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.cleartrip.config.ContextConfiguration;
import com.cleartrip.pageobjects.SearchFlightPage;
import com.cleartrip.pageobjects.SearchResultPage;
import com.cleartrip.testBase.TestBase;
import com.cleartrip.util.Utility;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@Component
public class StepDefinitions extends TestBase{

	@Autowired
    SearchFlightPage searchFlightPage;
	
	@Autowired
	SearchResultPage searchResultPage;
	
	@Autowired
    TestBase testBase;
	
	@Autowired 
	Environment env;

	@Before
	public void before(Scenario scenario) {
		
		this.scenario = scenario;
		selectBrowser();
		
		ApplicationContext context= new AnnotationConfigApplicationContext(ContextConfiguration.class);
		openApp();
		//System.out.println("driver in stepdefinition:" + driver);
		//System.out.println("searchPage in stepdefinition:" + searchFlightPage);
		//searchFlightPage.initializePage(driver);
		searchFlightPage=PageFactory.initElements(driver, SearchFlightPage.class);
		searchResultPage=PageFactory.initElements(driver, SearchResultPage.class);
	}

	@Given("^user navigates to cleartrip site$")
	public void openBrowser(){

		/*selectBrowser();
		openApp();
		System.out.println("Inside cleartrip site");
		System.out.println("driver in stepdefinition:" + driver);
		System.out.println("searchPage in stepdefinition:" + searchPage);
		searchPage.initializePage(driver);*/

	}

	@Then("^user verify search flight page$")
	public void verifyHomePageOfApp() throws InterruptedException{
		//SearchFlightPage searchPage = PageFactory.initElements(driver, SearchFlightPage.class);;
		searchFlightPage.verifySearchPage();
		
	}

	@When("^user click on \"([^\"]*)\" button$")
	public void selectButton(String buttonName){

	//	SearchFlightPage searchPage = PageFactory.initElements(driver, SearchFlightPage.class);
		searchFlightPage.selectButton(buttonName);
	}

	@When("^user enter \"([^\"]*)\" location$")
	public void enterLocation(String location){

		//SearchFlightPage searchPage = PageFactory.initElements(driver, SearchFlightPage.class);;

		String locationValue  = Utility.getValueFromExcel(scenario,location);

		searchFlightPage.enterLocation(location,locationValue);
	}

	@When("^user select \"([^\"]*)\" date$")
	public void enterDate(String dateType){

		//SearchFlightPage searchPage = PageFactory.initElements(driver, SearchFlightPage.class);;

		String dateValue  = Utility.getValueFromExcel(scenario,dateType);

		searchFlightPage.selectDateFromCalendar(dateType,dateValue);
	}

	@When("^user select \"([^\"]*)\" dropdown$")
	public void selectDropDown(String dropdownType){

		//SearchFlightPage searchPage = PageFactory.initElements(driver, SearchFlightPage.class);;

		String dropdownValue  = Utility.getValueFromExcel(scenario,dropdownType);

		searchFlightPage.selectValueFromDropDown(dropdownType, dropdownValue);
	}

	@Then("^user verify the searched flight$")
	public void verifySearchedFlight(){

	//	SearchResultPage searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);;
		searchResultPage.verifyListOfFlight();
	}
	
	/*@After
	public void closeBrowser(){
		
		tearDown();
		
	}*/
}

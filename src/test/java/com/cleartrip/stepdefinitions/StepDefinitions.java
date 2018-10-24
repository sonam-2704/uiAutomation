package com.cleartrip.stepdefinitions;

import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
public class StepDefinitions extends TestBase {

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

		openApp();
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
		searchFlightPage = context.getBean(SearchFlightPage.class);
		searchFlightPage.initializePage(driver);
		searchResultPage = context.getBean(SearchResultPage.class);
		searchResultPage.initializePage(driver);
	}

	@Given("^user navigates to cleartrip site and verify search flight page$")
	public void verifyCleartripHomePage() {

		searchFlightPage.verifySearchPage();
	}

	@Then("^user verify search flight page$")
	public void verifyHomePageOfApp() throws InterruptedException {
		searchFlightPage.verifySearchPage();

	}

	@When("^user click on \"([^\"]*)\" button$")
	public void selectButton(String buttonName) {

		searchFlightPage.selectButton(buttonName);
	}

	@When("^user enter \"([^\"]*)\" location$")
	public void enterLocation(String location) {

		String locationValue = Utility.getValueFromExcel(scenario, location);

		searchFlightPage.enterLocation(location, locationValue);
	}

	@When("^user select \"([^\"]*)\" date$")
	public void enterDate(String dateType) {

		String dateValue = Utility.getValueFromExcel(scenario, dateType);

		searchFlightPage.selectDateFromCalendar(dateType, dateValue);
	}

	@When("^user select \"([^\"]*)\" dropdown$")
	public void selectDropDown(String dropdownType) {

		String dropdownValue = Utility.getValueFromExcel(scenario, dropdownType);

		searchFlightPage.selectValueFromDropDown(dropdownType, dropdownValue);
	}

	@Then("^user verify the searched flight$")
	public void verifySearchedFlight() {

		searchResultPage.verifyListOfFlight();
	}

	@After
	public void closeBrowser() {

		tearDown();

	}
}

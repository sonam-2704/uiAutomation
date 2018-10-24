package com.cleartrip.stepdefinitions;

import com.cleartrip.api.APIValidation;
import com.cleartrip.testBase.TestBase;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

public class APIStepDefinition extends TestBase{

	
	Response response ;
	
	@Before
	public void beforeAPI(){
		
		response = apiInitialSetUp();
	}
	
	@Given("^user validates cleartrip API$")
	public void validateAPI(){

		APIValidation objAPIValidation = new APIValidation();

		objAPIValidation.validateAPIResponse();

	}
	
	@When("^user validates status code$")
	public void validateStatusCode(){

		APIValidation objAPIValidation = new APIValidation();

		objAPIValidation.validateStatusCodeResponse(response);

	}
	
	@When("^user validates header$")
	public void validateHeader(){

		APIValidation objAPIValidation = new APIValidation();

		objAPIValidation.validateHeaderResponse(response);

	}
	
	@When("^user validates city details$")
	public void validateCity(){

		APIValidation objAPIValidation = new APIValidation();

		objAPIValidation.validateBodyResponse(response);

	}
	
}

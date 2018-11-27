package com.cleartrip.stepdefinitions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.cleartrip.api.APIValidation;
import com.cleartrip.config.ContextConfiguration;
import com.cleartrip.testBase.TestBase;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
//import org.springframework.test.context.*;
//import org.springframework.test.context.ContextConfiguration;

public class APIStepDefinition extends TestBase {

	@Autowired
	APIValidation objAPIValidation;
	
	Response response;

	@Before
	public void beforeAPI() {

		@SuppressWarnings("resource")
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
		System.out.println("Context:" +context);
		objAPIValidation = context.getBean(APIValidation.class);
		response = apiInitialSetUp();
		
	}

	@Given("^user validates cleartrip API$")
	public void validateAPI() {

		objAPIValidation.validateAPIResponse();

	}

	@When("^user validates status code$")
	public void validateStatusCode() {

		objAPIValidation.validateStatusCodeResponse(response);

	}

	@When("^user validates header$")
	public void validateHeader() {

		objAPIValidation.validateHeaderResponse(response);

	}

	@When("^user validates city details$")
	public void validateCity() {

		objAPIValidation.validateBodyResponse(response);

	}

}

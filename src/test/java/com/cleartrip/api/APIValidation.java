package com.cleartrip.api;

import org.springframework.stereotype.Component;
import org.testng.Assert;
import com.cleartrip.testBase.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Component
public class APIValidation extends TestBase {

	public void validateAPIResponse() {

		String baseUrl = getValueFromProperiesFile("baseUrl");
		String methodUrl = getValueFromProperiesFile("methodUrl");

		RestAssured.baseURI = baseUrl;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, methodUrl);
		String responseBody = response.getBody().asString();
		Assert.assertEquals(response.getStatusCode(), 200, "Status code validation failed");
		Assert.assertEquals(response.getHeader("connection"), getValueFromProperiesFile("connection"),
				"Header validation failed for connection");
		Assert.assertEquals(response.getHeader("content-encoding"), getValueFromProperiesFile("content-encoding"),
				"Header validation failed for connection");
		Assert.assertEquals(response.getHeader("server"), getValueFromProperiesFile("server"),
				"Header validation failed for connection");
		Assert.assertTrue(responseBody.contains("Pune"), "Response city not validated successfully");
		Assert.assertTrue(responseBody.contains("PNQ"), "Response city code not validated successfully");

	}

	/**
	 * Method to validate status code 
	 *
	 */
	
	public void validateStatusCodeResponse(Response response) {

		Assert.assertEquals(response.getStatusCode(), 200, "Status code validation failed");

	}

	/**
	 * Method to validate header
	 *
	 */
	
	public void validateHeaderResponse(Response response) {

		Assert.assertEquals(response.getHeader("connection"), getValueFromProperiesFile("connection"),
				"Header validation failed for connection");
		Assert.assertEquals(response.getHeader("content-encoding"), getValueFromProperiesFile("content-encoding"),
				"Header validation failed for connection");
		Assert.assertEquals(response.getHeader("server"), getValueFromProperiesFile("server"),
				"Header validation failed for connection");

	}

	/**
	 * Method to validate response body
	 *
	 */
	
	public void validateBodyResponse(Response response) {

		// Response response = apiInitialSetUp();
		String responseBody = response.getBody().asString();
		Assert.assertTrue(responseBody.contains("Pune"), "Response city not validated successfully");
		Assert.assertTrue(responseBody.contains("PNQ"), "Response city code not validated successfully");

	}
}

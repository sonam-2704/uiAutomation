package com.cleartrip.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cleartrip.testBase.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIValidation extends TestBase{


	@Test
	public void validateAPIResponse(){

		String baseUrl = getValueFromProperiesFile("baseUrl");
		String methodUrl = getValueFromProperiesFile("methodUrl");

		RestAssured.baseURI = baseUrl;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, methodUrl);
		String responseBody = response.getBody().asString();
		//System.out.println("Response Body is =>  " + responseBody);

		/*	int statusCode = response.getStatusCode();
		System.out.println("Status code : "+statusCode);*/

		Assert.assertEquals(response.getStatusCode(), 200,"Status code validation failed");
		Assert.assertEquals(response.getHeader("connection"), getValueFromProperiesFile("connection"),"Header validation failed for connection");
		Assert.assertEquals(response.getHeader("content-encoding"), getValueFromProperiesFile("content-encoding"),"Header validation failed for connection");
		Assert.assertEquals(response.getHeader("server"), getValueFromProperiesFile("server"),"Header validation failed for connection");
		Assert.assertTrue(responseBody.contains("Pune"),"Response city not validated successfully");
		Assert.assertTrue(responseBody.contains("PNQ"),"Response city code not validated successfully");


	}

	public void validateStatusCodeResponse(Response response){

		//Response response = apiInitialSetUp();
		Assert.assertEquals(response.getStatusCode(), 200,"Status code validation failed");


	}
	public void validateHeaderResponse(Response response){

		//Response response = apiInitialSetUp();
		Assert.assertEquals(response.getHeader("connection"), getValueFromProperiesFile("connection"),"Header validation failed for connection");
		Assert.assertEquals(response.getHeader("content-encoding"), getValueFromProperiesFile("content-encoding"),"Header validation failed for connection");
		Assert.assertEquals(response.getHeader("server"), getValueFromProperiesFile("server"),"Header validation failed for connection");

	}

	public void validateBodyResponse(Response response){

		//Response response = apiInitialSetUp();
		String responseBody = response.getBody().asString();
		Assert.assertTrue(responseBody.contains("Pune"),"Response city not validated successfully");
		Assert.assertTrue(responseBody.contains("PNQ"),"Response city code not validated successfully");

	}
}

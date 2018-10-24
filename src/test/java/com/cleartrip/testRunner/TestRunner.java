package com.cleartrip.testRunner;

import org.testng.annotations.Listeners;

import cucumber.api.CucumberOptions;
//import net.serenitybdd.cucumber.CucumberWithSerenity;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@Listeners(com.cleartrip.listeners.TestNGListener.class)
@CucumberOptions(features="src/test/resources/featurefile",
glue={"com/cleartrip/stepdefinitions"},
plugin= {"pretty", "html:target/cucumber-reports/cucumber-pretty","json:target/cucumber-reports/CucumberTestReport.json"})

public class TestRunner extends AbstractTestNGCucumberTests{

}

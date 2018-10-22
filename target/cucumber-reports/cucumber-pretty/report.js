$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/featurefile/searchFlight.feature");
formatter.feature({
  "line": 2,
  "name": "Flight Search functionality",
  "description": "",
  "id": "flight-search-functionality",
  "keyword": "Feature"
});
formatter.before({
  "duration": 9105973070,
  "error_message": "java.lang.NullPointerException\r\n\tat com.cleartrip.stepdefinitions.StepDefinitions.before(StepDefinitions.java:49)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:34)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:13)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:30)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:59)\r\n\tat cucumber.runtime.Runtime.runHookIfTagsMatch(Runtime.java:222)\r\n\tat cucumber.runtime.Runtime.runHooks(Runtime.java:210)\r\n\tat cucumber.runtime.Runtime.runBeforeHooks(Runtime.java:200)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\r\n\tat cucumber.runtime.model.CucumberFeature.run(CucumberFeature.java:163)\r\n\tat cucumber.api.testng.TestNGCucumberRunner.runCucumber(TestNGCucumberRunner.java:63)\r\n\tat cucumber.api.testng.AbstractTestNGCucumberTests.feature(AbstractTestNGCucumberTests.java:21)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:124)\r\n\tat org.testng.internal.Invoker.invokeMethod(Invoker.java:583)\r\n\tat org.testng.internal.Invoker.invokeTestMethod(Invoker.java:719)\r\n\tat org.testng.internal.Invoker.invokeTestMethods(Invoker.java:989)\r\n\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:125)\r\n\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:109)\r\n\tat org.testng.TestRunner.privateRun(TestRunner.java:648)\r\n\tat org.testng.TestRunner.run(TestRunner.java:505)\r\n\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:455)\r\n\tat org.testng.SuiteRunner.runSequentially(SuiteRunner.java:450)\r\n\tat org.testng.SuiteRunner.privateRun(SuiteRunner.java:415)\r\n\tat org.testng.SuiteRunner.run(SuiteRunner.java:364)\r\n\tat org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)\r\n\tat org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:84)\r\n\tat org.testng.TestNG.runSuitesSequentially(TestNG.java:1208)\r\n\tat org.testng.TestNG.runSuitesLocally(TestNG.java:1137)\r\n\tat org.testng.TestNG.runSuites(TestNG.java:1049)\r\n\tat org.testng.TestNG.run(TestNG.java:1017)\r\n\tat org.testng.remote.AbstractRemoteTestNG.run(AbstractRemoteTestNG.java:114)\r\n\tat org.testng.remote.RemoteTestNG.initAndRun(RemoteTestNG.java:251)\r\n\tat org.testng.remote.RemoteTestNG.main(RemoteTestNG.java:77)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 4,
  "name": "Search flights One-way",
  "description": "",
  "id": "flight-search-functionality;search-flights-one-way",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "comments": [
    {
      "line": 5,
      "value": "#Given user navigates to cleartrip site"
    }
  ],
  "line": 6,
  "name": "user verify search flight page",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "user click on \"One way\" button",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user enter \"From\" location",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "user enter \"To\" location",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "user select \"Depart On\" date",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "user select \"Adults\" dropdown",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "user select \"Children\" dropdown",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "user select \"Infants\" dropdown",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "user click on \"Search\" button",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "user verify the searched flight",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.verifyHomePageOfApp()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "One way",
      "offset": 15
    }
  ],
  "location": "StepDefinitions.selectButton(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "From",
      "offset": 12
    }
  ],
  "location": "StepDefinitions.enterLocation(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "To",
      "offset": 12
    }
  ],
  "location": "StepDefinitions.enterLocation(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Depart On",
      "offset": 13
    }
  ],
  "location": "StepDefinitions.enterDate(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Adults",
      "offset": 13
    }
  ],
  "location": "StepDefinitions.selectDropDown(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Children",
      "offset": 13
    }
  ],
  "location": "StepDefinitions.selectDropDown(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Infants",
      "offset": 13
    }
  ],
  "location": "StepDefinitions.selectDropDown(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Search",
      "offset": 15
    }
  ],
  "location": "StepDefinitions.selectButton(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "StepDefinitions.verifySearchedFlight()"
});
formatter.result({
  "status": "skipped"
});
});
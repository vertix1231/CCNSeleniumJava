package com.versiontwo.ccn;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
//@CucumberOptions(features = "src/test/resources/features",
//monochrome= true,
//plugin = {"pretty", "junit:target/JUnitReports/report.xml",
//		"json:target/JSONReports/report.json",
//"html:target/HtmlReports.html"},tags="@subscription-2038-s6-2")
//public class SubscriptionRunTest {
//
//	@Test
//	public void test() {
//
//	}
//
//}

//@RunWith(Cucumber.class)
//@CucumberOptions(features = "src/test/resources/features",
//monochrome= true,
//plugin = {"pretty", "junit:target/JUnitReports/reportsubscription.xml",
//		"json:target/JSONReports/reportsubscription.json",
//"html:target/HtmlReportsubscriptions.html"},tags="@subscription-1874-s1 and @e2e")
//public class SubscriptionRunTest {
//
//	@Test
//	public void test() {
//
//	}
//
//}


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
monochrome= true,
plugin = {"pretty", "junit:target/JUnitReports/reportcsmgeos_2104.xml",
		"json:target/JSONReports/reportcsmgeos_2104.json",
"html:target/HtmlReportcsmgeos_2104.html"},tags="@subscriptionscsmgeos_2104_sg and @e2e")
public class GeolocationRunTest {

	@Test
	public void test() {

	}

}
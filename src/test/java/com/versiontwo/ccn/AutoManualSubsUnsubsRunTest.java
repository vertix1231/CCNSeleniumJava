package com.versiontwo.ccn;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
monochrome= true,
plugin = {"pretty", "junit:target/JUnitReports/reportcompany.xml",
		"json:target/JSONReports/reportcompany.json",
"html:target/HtmlReportscompany.html"},tags="@manual_post_subs_unsubs_awbedit")
public class AutoManualSubsUnsubsRunTest {

	@Test
	public void test() {

	}

}

//@RunWith(Cucumber.class)
//@CucumberOptions(features = "src/test/resources/features",
//monochrome= true,
//plugin = {"pretty", "junit:target/JUnitReports/report.xml",
//		"json:target/JSONReports/report.json",
//"html:target/HtmlReports.html"},tags="@subscription-2038-s6")
//public class CompanyRunTest {
//
//	@Test
//	public void test() {
//
//	}
//
//}
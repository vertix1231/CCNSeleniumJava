package com.versiontwo.ccn;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", monochrome = true, plugin = { "pretty",
		"junit:target/JUnitReports/reportsubscription.xml", "json:target/JSONReports/reportsubscription.json",
		"html:target/HtmlReportsubscriptions.html" }, tags = "@lfsmultiupgradedowngrade")
public class SubscriptionRunTest {

	@Test
	public void test() {

	}

}
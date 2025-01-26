package com.versiontwo.ccn;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
monochrome= true,
plugin = {"pretty", "junit:target/JUnitReports/reportlogin.xml",
		"json:target/JSONReports/reportlogin.json",
"html:target/HtmlReportslogin.html"},tags="@postpayment_in")
public class YopmailRunTest {

	@Test
	public void test() {

	}

}

package com.versiontwo.ccn;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
monochrome= true,
plugin = {"pretty", "junit:target/JUnitReports/reportSqpp.xml",
		"json:target/JSONReports/reportSqpp.json",
"html:target/HtmlReportsSqpp.html"},tags="@Sqpp-0-2")
public class SqppRunTest {

	@Test
	public void test() {

	}

}
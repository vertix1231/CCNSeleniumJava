package com.versiontwo.ccn;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
monochrome= true,
plugin = {"pretty", "junit:target/JUnitReports/reportPCN.xml",
		"json:target/JSONReports/reportPCN.json",
"html:target/HtmlReportsPCN.html"},tags="@create_user_company_my")
public class PCNRunTest {

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
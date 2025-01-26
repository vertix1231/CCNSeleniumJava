package com.versiontwo.ccn.utils;

public enum ScenarioTestCases {
	SCT1("Scenario Company Testing 1"),
	SCT2("Scenario Testing 2"),
	SCT3("Scenario Testing 3");
	
	private String scenarioTestName;

	ScenarioTestCases(String value){
		this.scenarioTestName  = value;
	}
	
	public String getScenarioTestName() {
		return scenarioTestName;
	}
	
	
	
}

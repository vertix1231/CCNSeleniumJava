package com.versiontwo.ccn.driver;

import com.versiontwo.ccn.utils.Constants;

public class DriverStrategyImplementor {
	public static DriverStrategy chooseStrategy(String strategy) {
		switch (strategy) {
		case Constants.CHROME:
			return new Chrome();

		case Constants.FIREFOX:
			return new FireFox();

		default:
			return null;
		}
	}
}

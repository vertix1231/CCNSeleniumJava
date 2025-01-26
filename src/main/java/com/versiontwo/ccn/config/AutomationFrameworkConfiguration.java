package com.versiontwo.ccn.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// untuk menjadikan sebagai pusat context spring framework
@Configuration
@ComponentScan("com.versiontwo.ccn")
public class AutomationFrameworkConfiguration {
	public AutomationFrameworkConfiguration() {

	}
}

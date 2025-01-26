package com.versiontwo.ccn.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UtilsTest {
	public static int scenariotestcount=0;
	public static String getProperties() {
        Properties properties = new Properties();
        try (FileInputStream fileStream = new FileInputStream("src/test/resources/application.properties")) {
            properties.load(fileStream);
            Constants.EMAIL = properties.getProperty("email");
            Constants.PASSWORD = properties.getProperty("password");
            Constants.MAIL_SERVICE = properties.getProperty("mail-service");
            Constants.MAIL_SERVICE_URL = properties.getProperty("mail-service-url");
            Constants.DISPLAY_NAME = properties.getProperty("display-name");
            Constants.COMPANY_NAME = properties.getProperty("company-name");
            Constants.COMPANY_PATH_URL = properties.getProperty("company-path-url");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty("server-url"); //server-url link
    }
}

package com.epam.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InternetExplorerDriverCreator extends WebDriverCreator {
	
	private static final String IE_DRIVER = "IEDriverServer.exe";
	private static final String IE_PROPERTY = "webdriver.ie.driver";

	public WebDriver factoryMethod() {
		System.setProperty(IE_DRIVER, IE_PROPERTY);
		WebDriver driver = new InternetExplorerDriver();
		return driver;
	}
}

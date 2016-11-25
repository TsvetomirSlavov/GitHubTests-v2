package com.epam.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

	private WebDriver driver;

	public BasePage(WebDriver driverAsInput) {
		//System.out.println(driverAsInput);
		//System.out.println(this.driver);

		this.driver = driverAsInput;
		//System.out.println(this.driver);

		PageFactory.initElements(driverAsInput, this);
	}

	protected WebDriver getDriver() {
		return driver;
	}

}

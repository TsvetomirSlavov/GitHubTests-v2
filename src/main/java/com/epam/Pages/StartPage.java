package com.epam.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage {

	@FindBy(linkText = "Sign in")
	private WebElement loginButton;

	public StartPage(WebDriver driverAsInput) {
		super(driverAsInput);
	}
	
	public LoginPage goToLoginPage() {
		loginButton.click();
		return new LoginPage(getDriver());
	}
}

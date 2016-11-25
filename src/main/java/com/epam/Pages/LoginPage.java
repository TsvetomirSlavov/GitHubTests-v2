package com.epam.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driverAsInput) {
		super(driverAsInput);
	}
	
	private WebElement login_field;
	private WebElement password;

	@FindBy(name = "commit")
	private WebElement buttonSignIn;


	public MainPage signIn(String username, String passwordKeys) {
		login_field.sendKeys(username);
		password.sendKeys(passwordKeys);
		buttonSignIn.click();
		return new MainPage(getDriver());
	}

}

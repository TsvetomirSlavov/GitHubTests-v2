package com.epam.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
	
	private WebElement dashboard;

	@FindBy(xpath = "//img[@alt='@arturdvorak']")
	private WebElement headerDropdown;
	
	@FindBy(linkText = "Your profile")
	private WebElement yourProfileInHeaderDropdown;
	
	@FindBy(xpath = "//a[contains(@href, '/arturdvorak?tab=repositories')]")
	private WebElement repositoriesTab;
	
	@FindBy(linkText = "Artur_Dvorak")
	private WebElement repositoriesLink;

	public MainPage(WebDriver driverAsInput) {
		super(driverAsInput);
	}
	
	public void verificationMain() {
		dashboard.isEnabled();
	}
	
	public void goToYourProfile() {
		headerDropdown.click();
		yourProfileInHeaderDropdown.click();
	}
	
	public void goToYourRepository() {
		repositoriesTab.click();
		repositoriesLink.click();
	}
}

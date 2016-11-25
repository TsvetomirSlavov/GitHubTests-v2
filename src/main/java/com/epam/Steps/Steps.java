package com.epam.Steps;

import org.openqa.selenium.WebDriver;

import com.epam.Driver.WebDriverSingleton;
import com.epam.Pages.LoginPage;
import com.epam.Pages.MainPage;
import com.epam.Pages.RepositoriesPage;
import com.epam.Pages.StartPage;

public class Steps {
	
	private WebDriver driver;

	public Steps() {
		WebDriver newInstanceOfDriver = WebDriverSingleton.getWebDriverInstance();
		this.driver = newInstanceOfDriver;
	}

	public void closeDriver() {
		driver.quit();
	}

	public void openStartPage(String url) {
		driver.get(url);
	}
	
	public void openLoginPage() {
		StartPage startPage = new StartPage(driver);
		startPage.goToLoginPage();
	}

	public void loginGitHub(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.signIn(username, password);
	}
	
	public void goToRepository() {
		MainPage mainPage = new MainPage(driver);
		mainPage.verificationMain();
		mainPage.goToYourProfile();
		mainPage.goToYourRepository();
	}
	
	public void printAmountOfFolders() {
		RepositoriesPage repositoriesPage = new RepositoriesPage(driver);
		repositoriesPage.printAmountOfFolders();
	}
	
}

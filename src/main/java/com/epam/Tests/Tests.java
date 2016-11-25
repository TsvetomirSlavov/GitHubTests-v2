package com.epam.Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.epam.Driver.CustomTestListener;
import com.epam.Steps.Steps;
import com.epam.reportportal.testng.ReportPortalTestNGListener;

@Listeners({ReportPortalTestNGListener.class, CustomTestListener.class})
public class Tests {
	
	private Steps steps;

	private final String USERNAME = "artur_dvorak@epam.com";
	private final String PASSWORD = "Apm7390708";
	private final String BASE_URL = "https://github.com/";


	@BeforeClass(description = "Init browser") 
	public void setUp() {
		steps = new Steps();
	}

	@Test 
	public void loginGitHub() {
		steps.openStartPage(BASE_URL);
		steps.openLoginPage();
		steps.loginGitHub(USERNAME, PASSWORD);
	}
	
	@Test 
	public void openYourRepository() {
		steps.goToRepository();
		steps.printAmountOfFolders();
	}

	@AfterClass(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}

}

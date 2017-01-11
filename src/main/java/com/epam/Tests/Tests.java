package com.epam.Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.epam.Driver.ConfigUtils;
import com.epam.Driver.CustomTestListener;
import com.epam.Steps.Steps;
import com.epam.reportportal.testng.ReportPortalTestNGListener;

@Listeners({ReportPortalTestNGListener.class, CustomTestListener.class})
public class Tests {
	
	private Steps steps;

	@BeforeClass(description = "Init browser") 
	public void setUp() {
		steps = new Steps();
	}

	@Test 
	public void loginGitHub() {
		steps.openStartPage(ConfigUtils.getProperty("BASE_URL"));
		steps.openLoginPage();
		steps.loginGitHub(ConfigUtils.getProperty("USERNAME"), ConfigUtils.getProperty("PASSWORD"));
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

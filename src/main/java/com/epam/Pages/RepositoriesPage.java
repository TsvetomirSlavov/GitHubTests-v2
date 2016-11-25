package com.epam.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RepositoriesPage extends BasePage {

	public RepositoriesPage(WebDriver driverAsInput) {
		super(driverAsInput);
	}
	
	public void printAmountOfFolders() {
		int rowCount = getDriver().findElements(By.xpath("//tr[contains(@class,'js-navigation-item')]")).size();
		System.out.println("Total number of rows :"+ rowCount);
	}
}

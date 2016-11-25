package com.epam.Driver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

public class WebDriverSingleton {

	private static WebDriver driver;

	private WebDriverSingleton() {
	}

	public static WebDriver getWebDriverInstance() {
		if (driver == null) {
			driver = createDriver();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}

		return driver;
	}

	public static void closeWebBrowser() {
		driver.quit();
		driver = null;
	}

	private static WebDriver createDriver() {
		WebDriverCreator creator;

		switch (ConfigSingleton.getConfigInstance().getBrowserType()) {
		case FF:
			creator = new FirefoxDriverCreator();
			break;
		case GC:
			creator = new ChromeDriverCreator();
			break;
		case IE:
			creator = new InternetExplorerDriverCreator();
			break;
		default:
			creator = new ChromeDriverCreator();
		}

		driver = creator.factoryMethod();
		return driver;
	}

}

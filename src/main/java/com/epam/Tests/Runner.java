package com.epam.Tests;

import org.testng.TestNG;

import com.epam.Driver.ConfigSingleton;

public class Runner {

	public static void main(String[] args) {
		
		ConfigSingleton.initConfig(args);
		
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { Tests.class });
		testng.run();
	}
}

package com.epam.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class ConfigUtils {
	
	public static String getProperty(String properyValue) {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("src/test/resources/config.properties");
			prop.load(input);

		} catch (IOException e) {
			System.out.println("Could not find config.properties");
		}

		return prop.getProperty(properyValue);
	}
	
	public static <T> void populateWithArgs(T config, String[] args) {
		try {
			new CmdLineParser(config).parseArgument(args);
		} catch (CmdLineException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
}

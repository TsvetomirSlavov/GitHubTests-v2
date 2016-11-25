package com.epam.Driver;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class ConfigUtils {
	
	public static <T> void populateWithArgs(T config, String[] args) {
		try {
			new CmdLineParser(config).parseArgument(args);
		} catch (CmdLineException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}

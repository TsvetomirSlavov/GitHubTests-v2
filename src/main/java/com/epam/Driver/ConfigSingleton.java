package com.epam.Driver;

import java.util.Arrays;

public class ConfigSingleton {

	private static CommonConfig config;

	private ConfigSingleton() {
	}

	public static CommonConfig getConfigInstance() {
		if (config == null) {
			config = new CommonConfig();
		}
		return config;
	}

	public static void initConfig(String[] args) {
		config = new CommonConfig();
		System.out.println(Arrays.asList(args));
		ConfigUtils.populateWithArgs(config, args);
	}

}

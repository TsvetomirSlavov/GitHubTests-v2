package com.epam.Driver;

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
		ConfigUtils.populateWithArgs(config, args);
	}

}

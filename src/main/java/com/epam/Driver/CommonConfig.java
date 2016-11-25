package com.epam.Driver;

import org.kohsuke.args4j.Option;

public class CommonConfig {

	@Option(name = "-browser")
	private BrowserType browser = BrowserType.GC;

	public BrowserType getBrowserType() {
		return browser;
	}

}

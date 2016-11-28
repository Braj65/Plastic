package com.trgr.elasticMon.base;

public class BrowserBase extends DriverFactory {

	@Override
	public DriverProductBase createFireDriver() {
		return new FireDriverBase();
	}

	@Override
	public DriverProductBase createChromeDriver() {
		return new ChromeDriverBase();
	}

}

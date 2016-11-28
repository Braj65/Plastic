package com.trgr.elasticMon.base;

public abstract class DriverFactory {
	public abstract DriverProductBase createWinFireDriver();
	public abstract DriverProductBase createChromeDriver();
	public abstract DriverProductBase createLinFireDriver();
}

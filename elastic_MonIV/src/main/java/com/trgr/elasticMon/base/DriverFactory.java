package com.trgr.elasticMon.base;

import org.openqa.selenium.support.events.EventFiringWebDriver;

public abstract class DriverFactory {
	public abstract DriverProductBase createWinFireDriver();
	public abstract DriverProductBase createChromeDriver();
	public abstract DriverProductBase createLinDriver();
	
	public abstract DriverProductBase createOsBasedDriver();
	
	public abstract void destroyDriver();
	public abstract void updateImplicitWait(int newWaitTime);
	
}

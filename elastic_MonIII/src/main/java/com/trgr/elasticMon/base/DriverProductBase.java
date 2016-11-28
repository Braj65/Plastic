package com.trgr.elasticMon.base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public abstract class DriverProductBase <T extends EventFiringWebDriver>{
	public T driver;
	public abstract EventFiringWebDriver createDriver();
	
	public void destroyDriver(){
		driver.quit();
	}
	
	public void editImplicitWait(int newWaitTime){
		driver.manage().timeouts().implicitlyWait(newWaitTime, TimeUnit.SECONDS);
	}
}

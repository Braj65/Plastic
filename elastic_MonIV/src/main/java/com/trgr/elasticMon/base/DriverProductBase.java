package com.trgr.elasticMon.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public abstract class DriverProductBase <T extends EventFiringWebDriver>{
	protected T driver;
	public abstract DriverProductBase createDriver();
	
	public T getRunner(){
		return driver;
	}
	
	public void destroyDriver(){
		this.getRunner().quit();
	}
	
	public void editImplicitWait(int newWaitTime){
		this.getRunner().manage().timeouts().implicitlyWait(newWaitTime, TimeUnit.SECONDS);
	}
	
}

package com.trgr.elasticMon.base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ClientProcessor {
	private final DriverProductBase winfirefox;
	private final DriverProductBase linfirefox;
	private final DriverProductBase chrome;
	private DriverProductBase driverHolder=null;
	private String os_name;
	
	public ClientProcessor(final DriverFactory factory){
		winfirefox=factory.createWinFireDriver();
		linfirefox=factory.createLinFireDriver();
		chrome=factory.createChromeDriver();
		os_name=System.getProperty("os.name");
	}
	
	public EventFiringWebDriver launchBrowser(){
		if(os_name.contains("Windows"))
			return runWinFireFox();
		else if(os_name.contains("Linux"))
			return runLinFireFox();
		else
			return runChrome();
	}
	
	private EventFiringWebDriver runWinFireFox(){
		return winfirefox.createDriver();
	}
	
	private EventFiringWebDriver runLinFireFox(){
		return linfirefox.createDriver();
	}
	
	private EventFiringWebDriver runChrome(){
		return chrome.createDriver();
	}
	
	public void updateImplicitWait(int newTime){
		this.getDriverHolder().editImplicitWait(newTime);
	}
	
	public void destroyDriver(){
		this.getDriverHolder().destroyDriver();		
	}
	
	private DriverProductBase getDriverHolder(){
		if(driverHolder!=null)
			return driverHolder;
		Field[] objs=this.getClass().getDeclaredFields();
		for(Field x:objs){
			try {
				if(x.get(this)!=null){
					if(x.getType().toString().contains("Driver")){
						driverHolder=(DriverProductBase) x.get(this);
						break;
					}
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		return driverHolder;
	}
	
}
package com.trgr.elasticMon.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ClientProcessor {
	private final DriverProductBase fireFox;
	private final DriverProductBase chrome;
	private String os_name;
	
	public ClientProcessor(final DriverFactory drive){
		fireFox=drive.createFireDriver();
		chrome=drive.createChromeDriver();
		os_name=System.getProperty("os.name");
	}
	
	public WebDriver launchBrowser(){
		if(os_name.contains("Windows"))
			return runFireFox();
		else if(os_name.contains("Linux"))
			return runFireFox();
		else
			return runChrome();
	}
	
	private WebDriver runFireFox(){
		return fireFox.createDriver();
	}	
	
	private WebDriver runChrome(){
		return chrome.createDriver();
	}
}

package com.trgr.elasticMon.base;

import java.io.File;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class DriverFactoryImpl extends DriverFactory{
	private final DriverProductBase winfirefox;
	private final DriverProductBase linfirefox;
	private final DriverProductBase chrome;
	
	private DriverProductBase driverHolder=null;
	
	public String os_name=null;
	private static WebDriver drive;
	
	
	public DriverFactoryImpl(){
		winfirefox=createWinFireDriver();
		linfirefox=createLinDriver();
		chrome=createChromeDriver();
		os_name=System.getProperty("os.name");
	}
	
	public DriverProductBase createOsBasedDriver(){
		if(os_name.toLowerCase().contains("window"))
			return winfirefox.createDriver();
		else if(os_name.toLowerCase().contains("linux"))
			return linfirefox.createDriver();
		else
			return chrome.createDriver();
		
	}

	@Override
	public DriverProductBase createWinFireDriver() {
		return new DriverProductBase<EventFiringWebDriver>(){
			@Override
			public DriverProductBase createDriver() {
				final DesiredCapabilities capa=new DesiredCapabilities();
				driver=this.getRunner();
				capa.setBrowserName("firefox");
				capa.setPlatform(org.openqa.selenium.Platform.ANY);
				capa.setJavascriptEnabled(true);
				capa.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capa.setCapability(CapabilityType.BROWSER_NAME, "firefox");
				drive=new FirefoxDriver(capa);
				driver=new EventFiringWebDriver(drive);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.executeScript("return document.readyState").equals("complete");
				return this;
			}			
		};
	}

	@Override
	public DriverProductBase createChromeDriver() {
		return new DriverProductBase<EventFiringWebDriver>(){
			@Override
			public DriverProductBase createDriver() {
				final DesiredCapabilities capa=new DesiredCapabilities();
				driver=this.getRunner();
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver/chromedriver.exe");
				capa.setCapability(CapabilityType.PLATFORM, "ANY");
				capa.setCapability(CapabilityType.BROWSER_NAME, "firefox");
				capa.setCapability(CapabilityType.ACCEPT_SSL_CERTS, "true");
				capa.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, "true");
				drive=new ChromeDriver(capa);
				driver=new EventFiringWebDriver(drive);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.executeScript("return document.readyState").equals("complete");
				return this;				
			}			
		};
	}

	@Override
	public DriverProductBase createLinDriver() {
		return new DriverProductBase<EventFiringWebDriver>(){
			@Override
			public DriverProductBase createDriver() {
				final DesiredCapabilities capa=new DesiredCapabilities();
				driver=this.getRunner();
				File firebinPath=new File("C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
				FirefoxBinary firebin=new FirefoxBinary(firebinPath);
				firebin.setEnvironmentProperty("DISPLAY", "99");
				capa.setCapability(CapabilityType.BROWSER_NAME, "firefox");
				capa.setCapability(CapabilityType.PLATFORM, "ANY");
				capa.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, "true");
				capa.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				drive=new FirefoxDriver(firebin, null, capa);
				driver=new EventFiringWebDriver(drive);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.executeScript("return document.readyState").equals("complete");
				return this;
			}	
		};
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
		try{
			Field[] factoryImplFields=this.getClass().getDeclaredFields();
			for(Field facField: factoryImplFields){
				System.out.println(facField.get(this));
				System.out.println(facField.getType().toString());
				if(facField.get(this)!=null && facField.getType().toString().toLowerCase().contains("driver")){
					Field[] dpBaseFields=facField.getType().getDeclaredFields();
					
					for(Field dpBaseField:dpBaseFields){
						System.out.println(dpBaseField.get(facField.get(this)));
						System.out.println(dpBaseField.getType().toString());
						if(dpBaseField.get(facField.get(this))!=null && dpBaseField.getType().toString().toLowerCase().contains("eventfiringwebdriver")){
							driverHolder=(DriverProductBase) facField.get(this);
							return driverHolder;
						}
					}
				}
			}
		}catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}

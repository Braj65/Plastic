package com.trgr.elasticMon.base;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Client {
	public static WebDriver driver=null;
	public static void main(String[] args){ 
		//DriverFactory d1=new BrowserBase();
		DriverFactory d2=new DriverFactory(){
			@Override
			public DriverProductBase createFireDriver() {
				return new DriverProductBase(){
					@Override
					public WebDriver createDriver() {
						DesiredCapabilities capa=new DesiredCapabilities();
						capa.setBrowserName("firefox");
						capa.setPlatform(org.openqa.selenium.Platform.ANY);
						capa.setJavascriptEnabled(true);
						capa.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
						driver=new FirefoxDriver(capa);
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
						driver.manage().window().maximize();
						return driver;
					}					
				};
			}
			@Override
			public DriverProductBase createChromeDriver() {
				return new DriverProductBase(){
					@Override
					public WebDriver createDriver() {
						System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver\\chromedriver.exe");
						driver=new ChromeDriver();
						return driver;
					}
				};
			}			
		};
		ClientProcessor c1=new ClientProcessor(d2);
		c1.launchBrowser();
		
	}
}

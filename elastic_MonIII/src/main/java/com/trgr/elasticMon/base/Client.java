package com.trgr.elasticMon.base;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Client {
	private static WebDriver drive;
	public static void main(String[] args){
		ClientProcessor cp=new ClientProcessor(new DriverFactory(){
			@Override
			public DriverProductBase createWinFireDriver() {
				return new DriverProductBase<EventFiringWebDriver>() {

					@Override
					public EventFiringWebDriver createDriver() {
						final DesiredCapabilities capa=new DesiredCapabilities();
						capa.setBrowserName("firefox");
						capa.setPlatform(org.openqa.selenium.Platform.ANY);
						capa.setJavascriptEnabled(true);
						capa.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
						drive=new FirefoxDriver(capa);
						driver=new EventFiringWebDriver(drive);
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
						driver.manage().window().maximize();
						driver.executeScript("return document.readyState").equals("complete");
						return driver;
					}
				};
			}

			@Override
			public DriverProductBase createChromeDriver() {
				return new DriverProductBase(){

					@Override
					public EventFiringWebDriver createDriver() {
						System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver/chromedriver.exe");
						drive=new ChromeDriver();
						driver=new EventFiringWebDriver(drive);
						return driver;
					}					
				};
			}

			@Override
			public DriverProductBase createLinFireDriver() {
				return new DriverProductBase(){

					@Override
					public EventFiringWebDriver createDriver() {
						final FirefoxBinary fBin=new FirefoxBinary();
						final DesiredCapabilities capa=new DesiredCapabilities();
						fBin.setEnvironmentProperty("DISPLAY", "99");
						capa.setBrowserName("firefox");
						capa.setPlatform(org.openqa.selenium.Platform.ANY);
						capa.setJavascriptEnabled(true);
						capa.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
						drive=new FirefoxDriver(fBin, null, capa);
						driver=new EventFiringWebDriver(drive);
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
						driver.manage().window().maximize();
						driver.executeScript("return document.readyState").equals("complete");
						return driver;
					}				
				};
			}			
		});
		EventFiringWebDriver driver=cp.launchBrowser();
		cp.updateImplicitWait(20);
	}
}

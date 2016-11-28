package com.trgr.elasticMon.base.command;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.trgr.elasticMon.base.ClientProcessor;
import com.trgr.elasticMon.base.DriverFactory;
import com.trgr.elasticMon.base.DriverProductBase;

public class Browser {
	public WebDriver driver;
	public WebDriver Action(){
		ClientProcessor cp=new ClientProcessor(new DriverFactory(){
			@Override
			public DriverProductBase createFireDriver() {
				return new DriverProductBase(){
					@Override
					public WebDriver createDriver() {
						final DesiredCapabilities capa=new DesiredCapabilities();
						capa.setBrowserName("firefox");
						capa.setPlatform(org.openqa.selenium.Platform.ANY);
						capa.setJavascriptEnabled(true);
						capa.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
						driver=new FirefoxDriver(capa);
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
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
		});
		driver=cp.launchBrowser();
		return driver;		
	}
}

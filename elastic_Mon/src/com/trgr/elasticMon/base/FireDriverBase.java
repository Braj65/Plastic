package com.trgr.elasticMon.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FireDriverBase extends DriverProductBase{
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
}

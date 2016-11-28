package com.trgr.elasticMon.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
	
public class ChromeDriverBase extends DriverProductBase{
	@Override
	public WebDriver createDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		return driver;
	}
}

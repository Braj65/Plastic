package com.trgr.elasticMon.base.command;

import org.openqa.selenium.WebDriver;

import com.trgr.elasticMon.base.ChromeDriverBase;
import com.trgr.elasticMon.base.ClientProcessor;
import com.trgr.elasticMon.base.DriverFactory;
import com.trgr.elasticMon.base.DriverProductBase;
import com.trgr.elasticMon.base.FireDriverBase;
import com.trgr.elasticMon.base.BrowserBase;

public class Browser {
	public WebDriver driver;
	public WebDriver Action(){
		DriverFactory df=new BrowserBase();
		ClientProcessor cp=new ClientProcessor(df);
		driver=cp.launchBrowser();
		return driver;		
	}
}

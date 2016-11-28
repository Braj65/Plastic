package com.trgr.elasticMon.base;

import java.util.Properties;

public class Client {
	public static void main(String[] args){ 
		DriverFactory d1=new BrowserBase();
		ClientProcessor c1=new ClientProcessor(d1);
		c1.launchBrowser();
		
	}
}

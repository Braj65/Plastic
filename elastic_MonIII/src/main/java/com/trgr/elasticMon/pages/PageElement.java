package com.trgr.elasticMon.pages;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public abstract class PageElement {
	
	public abstract PageElement getTargetPage();
	
	public PageElement initialize(EventFiringWebDriver driver, Class T){
		return PageFactory.initElements(driver, T);
	}
}

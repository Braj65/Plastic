package com.trgr.elasticMon.pages;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Client {
	
	public static void main(String[] args){
		PageVisitor<?> v=new ConcreteVisitor(new EventFiringWebDriver(new FirefoxDriver()));
		v.getPage(DashBoardPage.class);
	}

}

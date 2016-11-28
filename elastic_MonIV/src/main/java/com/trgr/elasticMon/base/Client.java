package com.trgr.elasticMon.base;

public class Client {
	public static void main(String[] args){
		DriverFactory fact=new DriverFactoryImpl();
		DriverProductBase dDriver=fact.createOsBasedDriver();
		dDriver.getRunner().get("http://www.google.co.uk");
		fact.updateImplicitWait(30);	
	}

}

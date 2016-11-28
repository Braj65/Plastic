package com.trgr.elasticMon.base.command;

import org.openqa.selenium.WebDriver;

public class Invoker {
	public Command com;
	
	/*public Invoker(Command c){
		com=c;
	}*/
	
	public Object execute(Command c){
		com=c;
		return com.execute();
	}
	
	public Object execute(Object obj, Command c){
		com=c;
		return com.execute(obj);
	}
}

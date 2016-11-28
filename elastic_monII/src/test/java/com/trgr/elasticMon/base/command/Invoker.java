package com.trgr.elasticMon.base.command;

import org.openqa.selenium.WebDriver;

public class Invoker {
	public Command com;
	
	/*public Invoker(Command c){
		com=c;
	}*/
	
	public Object execute(final Command c){
		com=c;
		return com.execute();
	}
	
	public Object execute(final Object obj, final Command c){
		com=c;
		return com.execute(obj);
	}
}

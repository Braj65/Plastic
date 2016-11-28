package com.trgr.elasticMon.command;

public class Invoker {

	private Command com;
	
	public Object execute(final Command c){
		com=c;
		return com.execute();
	}
	
	public Object execute(final Object obj, final Command c){
		com=c;
		return com.execute(obj);
	}

}

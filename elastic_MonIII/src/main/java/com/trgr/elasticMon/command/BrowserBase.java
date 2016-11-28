package com.trgr.elasticMon.command;

public class BrowserBase implements Command{

	private final Browser myBrowser;
	
	public BrowserBase(Browser rece){
		myBrowser=rece;
	}
	@Override
	public Object execute() {
		return myBrowser.Action();
	}

	@Override
	public Object execute(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}

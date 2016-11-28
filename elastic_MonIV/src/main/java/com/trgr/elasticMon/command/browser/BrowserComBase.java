package com.trgr.elasticMon.command.browser;

import com.trgr.elasticMon.command.Command;

public class BrowserComBase implements Command{
	
	public BrowserComBase(BrowserReceiver rece){
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

	public BrowserReceiver myBrowser;
	
	

}

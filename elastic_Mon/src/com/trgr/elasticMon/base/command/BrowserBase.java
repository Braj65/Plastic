package com.trgr.elasticMon.base.command;

public class BrowserBase extends Command{

	private Browser myBrowser;
	public BrowserBase(Browser rece) {
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

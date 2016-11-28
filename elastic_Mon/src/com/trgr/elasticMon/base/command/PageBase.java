package com.trgr.elasticMon.base.command;

public class PageBase extends Command{

	private Pages pages;
	
	public PageBase(Pages p){
		pages=p;
	}
	@Override
	public Object execute() {
		//return pages.Action();
		return null;
	
	}
	@Override
	public Object execute(Object obj) {
		return pages.Action(obj);
		//return null;
	}

}

package com.trgr.elasticMon.base.command;

public class PageBase extends Command{

	private final Pages pages;
	
	public PageBase(Pages p){
		pages=p;
	}
	@Override
	public Object execute() {
		//return pages.Action();
		return null;
	
	}
	@Override
	public Object execute(final Object obj) {
		return pages.Action(obj);
		//return null;
	}

}

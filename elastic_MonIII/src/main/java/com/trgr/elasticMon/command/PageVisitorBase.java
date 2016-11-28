package com.trgr.elasticMon.command;

public class PageVisitorBase implements Command{
	private final PageVisit pageVis;
	
	public PageVisitorBase(PageVisit rece){
		pageVis=rece;
	}

	@Override
	public Object execute() {
		return null;
	}

	@Override
	public Object execute(final Object obj) {
		return pageVis.Action(obj);
	}

}

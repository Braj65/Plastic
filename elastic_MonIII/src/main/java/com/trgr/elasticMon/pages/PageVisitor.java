package com.trgr.elasticMon.pages;

public abstract class PageVisitor <T extends PageElement>{
	T page; 
	public abstract void visit(PageElement e);
	public abstract T getPage(Class<?> T);
}

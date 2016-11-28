package com.trgr.elasticMon.pages;

import java.util.ArrayList;
import java.util.List;

public class ObjectProcessor {
	private List<PageElement> ele;
	
	public ObjectProcessor(){
		ele=new ArrayList<PageElement>();
	}
	
	public void Accept(PageVisitor v){
		for(PageElement e: ele)
			e.getTargetPage();
	}
	
	public void attach(PageElement e){
		ele.add(e);
	}
	
	public void detach(PageElement e){
		ele.remove(e);
	}
}

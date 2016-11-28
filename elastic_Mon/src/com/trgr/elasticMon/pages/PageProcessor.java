package com.trgr.elasticMon.pages;

import java.util.ArrayList;
import java.util.List;

import com.trgr.elasticMon.pages.actions.ActionBase;

public class PageProcessor {
	public List<ActionBase> lab=new ArrayList<ActionBase>();
	
	public void Accept(PageVisitor pv){
		for(ActionBase ab:lab){
			ab.Accept(pv);
		}
	}
}

package com.trgr.elasticMon.pages.actions;

import com.trgr.elasticMon.pages.PageVisitor;
import com.trgr.elasticMon.pages.util.PageUtilActions;


public abstract class ActionBase {
	public PageUtilActions pageUtils=new PageUtilActions();
	
	public abstract void Accept(PageVisitor visitor);
}

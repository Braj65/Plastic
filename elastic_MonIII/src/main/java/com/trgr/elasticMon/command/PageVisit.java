package com.trgr.elasticMon.command;

import com.trgr.elasticMon.pages.ConcreteVisitor;
import com.trgr.elasticMon.pages.PageVisitor;

public class PageVisit {
	ProcessorService p;
	public ConcreteVisitor Action(Object obj){
		p=(ProcessorService) obj;
		return new ConcreteVisitor(p.driver);
	}

}

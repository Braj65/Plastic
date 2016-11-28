package com.trgr.elasticMon.base.command;

import org.openqa.selenium.support.PageFactory;

import com.trgr.elasticMon.pages.DashBoardPage;
import com.trgr.elasticMon.pages.NodeDetailsPage;

public class Pages {
	public DashBoardPage dashPage;
	public NodeDetailsPage nodePage;
	public Pages Action(Object obj){
		Processor p=(Processor)obj;
		dashPage=PageFactory.initElements(p.driver, DashBoardPage.class);
		nodePage=PageFactory.initElements(p.driver, NodeDetailsPage.class);
		return this;
	}

}

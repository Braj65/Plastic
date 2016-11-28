package com.trgr.elasticMon.command;

import org.openqa.selenium.support.PageFactory;

import com.trgr.elasticMon.pages.DashBoardPage;
import com.trgr.elasticMon.pages.NodeDetailsPage;

public class Pages {
	public NodeDetailsPage nodePage;
	public DashBoardPage dashPage;		
	public Pages Action(Object obj){
		ProcessorService p=(ProcessorService)obj;
		dashPage=PageFactory.initElements(p.driver, DashBoardPage.class);
		nodePage=PageFactory.initElements(p.driver, NodeDetailsPage.class);
		return this;
	}
}

package com.trgr.elasticMon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NodeDetailsPage extends PageElement{
	
	@FindBy(how=How.XPATH, using="//*[@name='q']")
	public WebElement lnk_ClusterDetails;
	
	public void access(PageVisitor vis){
		vis.visit(this);
	}
	
	@Override
	public NodeDetailsPage getTargetPage(){
		return new NodeDetailsPage();
	}

}


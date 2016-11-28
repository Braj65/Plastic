package com.trgr.elasticMon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage extends PageElement{
	
	@FindBy(how=How.XPATH, using="//*[@name='q']")
	public WebElement lnk_ClusterDetails;
	
	@FindBy(how=How.XPATH, using="//*[@id='SubmitCreds']")
	@CacheLookup
	public WebElement btn_TestButton;
	
	public void access(PageVisitor vis){
		vis.visit(this);
	}
	
	@Override
	public DashBoardPage getTargetPage(){
		return new DashBoardPage();
	}
	
	/*public void initilaize(){
		DashBoardPage dpage=PageFactory.initElements(new FirefoxDriver(), DashBoardPage.class);
	}*/

}

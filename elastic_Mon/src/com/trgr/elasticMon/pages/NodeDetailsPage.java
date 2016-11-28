package com.trgr.elasticMon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.trgr.elasticMon.pages.actions.ActionBase;

public class NodeDetailsPage extends PageVisitor{

	@FindBy(how=How.XPATH, using="")
	@CacheLookup
	public WebElement btn_TestButton;
	
	@FindBy(how=How.XPATH, using="")
	@CacheLookup
	public WebElement btn_StartButton;
	
	@FindBy(how=How.XPATH, using="")
	public WebElement btn_StopButton;

	@Override
	public void click_lnk(WebElement ele) {
		clk_link.click(this, ele);		
	}

	@Override
	public void press_btn(WebElement ele) {
		prs_btn.press(this, ele);		
	}

	@Override
	public void visit(ActionBase docPart) {
		
	}

}

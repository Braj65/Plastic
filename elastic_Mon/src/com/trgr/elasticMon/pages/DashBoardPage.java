package com.trgr.elasticMon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.trgr.elasticMon.base.command.Processor;
import com.trgr.elasticMon.pages.actions.ActionBase;
import com.trgr.elasticMon.util.property.Property;

public class DashBoardPage extends PageVisitor{
	/*enum choice{
		Choice1,
		Choice2
	}*/

	//private final String lnk_ClustDtls=System.getProperty("lnk_ClusterDetails").toString();
	//private final String lnk_ClustDtls="Jammer";
	//private final String btn_TstBtn=System.getProperty("btn_TestButton");
	
	
	@FindBy(how=How.XPATH, using="//*[@name='q']")
	@CacheLookup
	public WebElement lnk_ClusterDetails;
	
	@FindBy(how=How.XPATH, using="btn_TstBtn")
	@CacheLookup
	public WebElement btn_TestButton;
	
	@Override
	public void click_lnk(WebElement ele){
		clk_link.click(this, ele);
	}
	
	@Override
	public void press_btn(WebElement ele){
		prs_btn.press(this, ele);
	}

	@Override
	public void visit(ActionBase docPart) {
		
	}

}

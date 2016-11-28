package com.trgr.elasticMon.pages;

import java.lang.reflect.Method;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.trgr.elasticMon.base.command.Processor;
import com.trgr.elasticMon.pages.actions.ActionBase;
import com.trgr.elasticMon.util.logs.Log;
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
	
	@FindBy(how=How.XPATH, using="//*[@id='SubmitCreds']")
	@CacheLookup
	public WebElement btn_TestButton;
	
	@Override
	public void click_lnk(final WebElement ele){
		try {
			clk_link.getClass().getMethod("click", Object.class, WebElement.class).invoke(this, ele);
		} catch (Exception e) {
			e.printStackTrace();
			Log.error(e.getMessage());
		}
	}
	
	@Override
	public void press_btn(final WebElement ele){
		try{
			//prs_btn.getClass().getMethod("press", Object.class, WebElement.class).invoke(this, ele);
			prs_btn.getClass().getMethod("press", Object.class, WebElement.class).invoke(prs_btn, this, ele);
		} catch(Exception e){
			e.printStackTrace();
			Log.error(e.getMessage());
		}
	}

	@Override
	public void visit(ActionBase docPart) {
		
	}

}

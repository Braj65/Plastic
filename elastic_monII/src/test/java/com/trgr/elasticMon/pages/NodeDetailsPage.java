package com.trgr.elasticMon.pages;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.trgr.elasticMon.pages.actions.ActionBase;
import com.trgr.elasticMon.util.logs.Log;

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
	public void click_lnk(final WebElement ele) {
		try {
			clk_link.getClass().getMethod("click", Object.class, WebElement.class).invoke(this, ele);
		} catch (Exception e) {
			e.printStackTrace();
			Log.error(e.getMessage());
		}
	}

	@Override
	public void press_btn(final WebElement ele) {
		try{
			prs_btn.getClass().getMethod("press", Object.class, WebElement.class).invoke(this, ele);
		} catch(Exception e){
			e.printStackTrace();
			Log.error(e.getMessage());
		}
			
	}

	@Override
	public void visit(ActionBase docPart) {
		
	}

}

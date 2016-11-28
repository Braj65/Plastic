package com.trgr.elasticMon.pages.actions;

import org.openqa.selenium.WebElement;

import com.trgr.elasticMon.pages.PageVisitor;

public class PressBtnAction extends ActionBase{

	@Override
	public void Accept(PageVisitor visitor) {
		visitor.visit(this);
	}
	
	public void press(Object obj, WebElement ele){
		if(pageUtils.isPresent(ele)==false)
			org.junit.Assert.fail("Element "+ele+"not present in the page "+obj.getClass().getName());
		else
			ele.click();
	}

}

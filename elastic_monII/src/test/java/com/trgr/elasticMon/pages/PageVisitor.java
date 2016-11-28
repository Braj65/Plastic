package com.trgr.elasticMon.pages;

import org.openqa.selenium.WebElement;

import com.trgr.elasticMon.pages.actions.ActionBase;

public abstract class PageVisitor {

	protected final ActionBase clk_link=new ActionBase(){
		@Override
		public void Accept(final PageVisitor visitor) {
			visitor.visit(this);
		}
		
		public void click(final Object obj, final WebElement ele){
			if(pageUtils.isPresent(ele)==false)
				org.junit.Assert.fail("Element "+ele+"not present in the page "+obj.getClass().getName());
			else
				ele.click();	
		}
	};
	protected final ActionBase prs_btn=new ActionBase(){
		@Override
		public void Accept(PageVisitor visitor) {
			visitor.visit(this);
		}
		
		public void press(final Object obj, final WebElement ele){
			if(pageUtils.isPresent(ele)==false)
				org.junit.Assert.fail("Element "+ele+"not present in the page "+obj.getClass().getName());
			else
				ele.click();
		}
	};
	public abstract void click_lnk(final WebElement ele);
	public abstract void press_btn(final WebElement ele);
	public abstract void visit(final ActionBase docPart);
}

package com.trgr.elasticMon.pages;

import org.openqa.selenium.WebElement;

import com.trgr.elasticMon.pages.actions.ActionBase;
import com.trgr.elasticMon.pages.actions.ClickLinkAction;
import com.trgr.elasticMon.pages.actions.PressBtnAction;

public abstract class PageVisitor {
	protected ClickLinkAction clk_link=new ClickLinkAction();
	protected PressBtnAction prs_btn=new PressBtnAction();
	public abstract void click_lnk(WebElement ele);
	public abstract void press_btn(WebElement ele);
	public abstract void visit(ActionBase docPart);
}

package com.trgr.elasticMon.pages.util;

import org.openqa.selenium.WebElement;

public class PageUtilActions {
	
	public boolean isPresent(WebElement ele){
		return ele.isDisplayed();
	}

}

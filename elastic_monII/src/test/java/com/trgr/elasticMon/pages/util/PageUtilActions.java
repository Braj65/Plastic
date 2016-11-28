package com.trgr.elasticMon.pages.util;

import org.openqa.selenium.WebElement;

public class PageUtilActions {
	
	public boolean isPresent(final WebElement ele){
		return ele.isDisplayed();
	}

}

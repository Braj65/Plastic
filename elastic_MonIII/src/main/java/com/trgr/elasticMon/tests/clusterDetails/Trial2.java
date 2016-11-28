package com.trgr.elasticMon.tests.clusterDetails;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Trial2 {
	public static void main(String[] args) {
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("https://www.reddit.com/r/books/wiki/scary");
		WebElement container=driver.findElement(By.xpath("//*[@id='header']/following-sibling::div[2]/div/div/table/tbody"));
		List<WebElement> rows=container.findElements(By.tagName("tr"));
		String a="";
		String b="";
		for(WebElement x:rows){
			a=x.findElement(By.xpath("./td[1]")).getText();
			b=x.findElement(By.xpath("./td[2]")).getText();
			System.out.println(a+"- "+b);
		}
	}

}

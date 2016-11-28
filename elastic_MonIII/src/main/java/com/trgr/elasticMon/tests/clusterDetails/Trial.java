package com.trgr.elasticMon.tests.clusterDetails;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Trial {
	public static void main(String[] args) {

		FirefoxDriver driver=new FirefoxDriver();
		driver.get("https://www.reddit.com/r/books/wiki/nonfiction");
		WebElement container=driver.findElement(By.xpath("//*[@id='header']/following-sibling::div[2]"));
		
		List<WebElement> heads=container.findElements(By.tagName("h3"));
		System.out.println(heads.size());
		String a="";
		String b="";
		for(WebElement x:heads){
			System.out.println(x.getText());
			System.out.println("-------------------");
			List<WebElement> rows=x.findElements(By.xpath("./following-sibling::table[1]/tbody/*"));
//			System.out.println(rows.size());
			for(WebElement y:rows){
				a=y.findElement(By.xpath("./td[1]")).getText();
				b=y.findElement(By.xpath("./td[2]")).getText();
				System.out.println(a+"- "+b);
			}
			System.out.println();
		}
	
	}

}

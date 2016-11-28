package com.trgr.elasticMon.base.command;

import org.openqa.selenium.WebDriver;

import com.trgr.elasticMon.config.properties.load.ConfigProps;
import com.trgr.elasticMon.util.files.FileReaderBase;

public class Processor {
	
	public WebDriver driver;
	public ConfigProps props;
	public FileReaderBase fileRead;
	public Pages pages;
	public void run(final Object obj){
		Browser r=new Browser();
		BrowserBase bb=new BrowserBase(r);
		/*Command browserBase=new Command(){
			private Browser myBrowser;
			{
				
			}
			@Override
			public Object execute() {
				return myBrowser.Action();		
			}

			@Override
			public Object execute(Object obj) {
				// TODO Auto-generated method stub
				return null;
			}
		};*/
		Invoker i=new Invoker();
		driver=(WebDriver) i.execute(bb);
		Property p=new Property();
		PropertyBase pb=new PropertyBase(p);
		//i=new Invoker(pb);
		props=(ConfigProps) i.execute(obj, pb);
		FileLoader fl=new FileLoader();
		FileLoaderBase flb=new FileLoaderBase(fl);
		//i=new Invoker(flb);
		fileRead=(FileReaderBase) i.execute(flb);
		Pages page=new Pages();
		PageBase pbase=new PageBase(page);
		//i=new Invoker(pb);
		pages=(Pages) i.execute(this, pbase);
	}
	
}

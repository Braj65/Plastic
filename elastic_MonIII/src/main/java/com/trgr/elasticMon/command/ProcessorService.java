package com.trgr.elasticMon.command;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.trgr.elasticMon.config.properties.load.ConfigProps;
import com.trgr.elasticMon.pages.ConcreteVisitor;
import com.trgr.elasticMon.util.fileLoad.FileReaderBase;

public class ProcessorService implements ProcessorServiceAbs{
	
	public EventFiringWebDriver driver;
	public ConfigProps props;
	public FileReaderBase fileRead;
	public Pages pages;
	public ConcreteVisitor pgVisit;
	Invoker i;
	public void run(final Object obj){
		i=new Invoker();
		Command bwb=new BrowserBase(new Browser());
		driver=(EventFiringWebDriver) i.execute(bwb);
		Command prop=new PropertyBase(new Property());
		props=(ConfigProps) i.execute(prop);
		Command fileLoad=new FileLoaderBase(new FileLoader());
		fileRead=(FileReaderBase) i.execute(fileLoad);
		Command pBase=new PageBase(new Pages());
		pages=(Pages)i.execute(this, pBase);
		Command pageVisitBase=new PageVisitorBase(new PageVisit());
		pgVisit=(ConcreteVisitor) i.execute(this, pageVisitBase);
	}
	
	public EventFiringWebDriver getDriver() {
		return driver;
	}
	public ConfigProps getProps() {
		return props;
	}
	public FileReaderBase getFileRead() {
		return fileRead;
	}
	public Pages getPages() {
		return pages;
	}
	public ConcreteVisitor getPgVisit() {
		return pgVisit;
	}

}

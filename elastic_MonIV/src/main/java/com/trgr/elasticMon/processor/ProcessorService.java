package com.trgr.elasticMon.processor;

import com.trgr.elasticMon.base.DriverProductBase;
import com.trgr.elasticMon.command.Command;
import com.trgr.elasticMon.command.Invoker;
import com.trgr.elasticMon.command.browser.BrowserComBase;
import com.trgr.elasticMon.command.browser.BrowserReceiver;

public class ProcessorService implements ProcessorServiceAbs{

	Invoker i;
	public DriverProductBase driverBase;
	
	@Override
	public void run(Object obj) {
		i=new Invoker();
		Command brwb=new BrowserComBase(new BrowserReceiver());
		driverBase=(DriverProductBase) i.execute(brwb);
		
	}

	@Override
	public DriverProductBase getDriver() {
		return driverBase;
	}

}

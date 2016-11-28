package com.trgr.elasticMon.command.browser;

import com.trgr.elasticMon.base.DriverFactory;
import com.trgr.elasticMon.base.DriverFactoryImpl;
import com.trgr.elasticMon.base.DriverProductBase;

public class BrowserReceiver {

	public DriverProductBase Action() {
		DriverFactory fac=new DriverFactoryImpl();
		return fac.createOsBasedDriver();
	}

}

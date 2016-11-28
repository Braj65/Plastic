package com.trgr.elasticMon.base.command;

import com.trgr.elasticMon.config.properties.load.ConfigProps;

public class Property {
	public ConfigProps Action(Object obj){
		String file="config.properties";
		ConfigProps cp=new ConfigProps(obj, file);
		//cp.addFile(obj, "DashBoardPage.properties");
		//cp.addFile(obj, "NodeDetailsPage.properties");
		return cp;
	}
}

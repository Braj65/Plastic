package com.trgr.elasticMon.command;

import com.trgr.elasticMon.config.properties.load.ConfigProps;

public class Property {
	public ConfigProps Action(Object obj){
		String file="config.properties";
		final ConfigProps cp=new ConfigProps(obj, file);
		return cp;
	}
}

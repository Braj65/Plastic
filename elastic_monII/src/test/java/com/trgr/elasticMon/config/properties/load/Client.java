package com.trgr.elasticMon.config.properties.load;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Client{
	
	public static void main(String[] args) throws Throwable{
		//String file="\\src\\com\\trgr\\elasticMon\\config\\properties\\config.properties";
		String file="config.properties";
		ConfigProps u=new ConfigProps(Client.class.newInstance(), file);
		System.out.println(u.getProp("browser"));
		//file="\\src\\com\\trgr\\elasticMon\\config\\properties\\monitorConfig.properties";
		file="monitorConfig.properties";
		u.addFile(Client.class.newInstance(), file);
		System.out.println(u.getProp("monitor"));
		System.out.println(System.getProperty("browser"));
	}
}

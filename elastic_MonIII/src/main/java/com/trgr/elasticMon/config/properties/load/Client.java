package com.trgr.elasticMon.config.properties.load;

public class Client {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException{
		String file="/src/main/java/com/trgr/elasticMon/config/properties/files/config.properties";
		ConfigProps u=new ConfigProps(Client.class.newInstance(), file);
		System.out.println(u.getProperty("Jam"));
		file="/src/main/java/com/trgr/elasticMon/config/properties/files/monitorConfig.properties";
		u.addFile(Client.class.newInstance(), file);
		System.out.println(u.getProperty("browser"));
		System.out.println(u.getProperty("Jam"));
	}
}

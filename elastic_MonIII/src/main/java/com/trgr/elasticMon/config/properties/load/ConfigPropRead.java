package com.trgr.elasticMon.config.properties.load;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.trgr.elasticMon.util.fileLoad.FileReader;
import com.trgr.elasticMon.util.fileLoad.FileReaderBase;

public class ConfigPropRead {
	public Properties prop;
	public FileInputStream fileIn;
	public FileReaderBase loadRoot;
	
	public ConfigPropRead(final Object obj, final String fileName){
		loadRoot=new FileReader();
		try {
			fileIn=new FileInputStream(loadRoot.extractFilePath(obj, fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void loadConfigProp(){
		try {
			prop=new Properties(System.getProperties());
			prop.load(fileIn);
			System.setProperties(prop);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fileIn.close();
			} catch (IOException e) {
				org.junit.Assert.fail(e.getMessage());
			}
		}
	}
	
	public String getConfigProp(String key){
		return System.getProperty(key)!=null?System.getProperty(key):null;
	}
}

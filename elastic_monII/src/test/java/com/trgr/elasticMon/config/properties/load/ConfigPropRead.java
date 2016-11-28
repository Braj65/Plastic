package com.trgr.elasticMon.config.properties.load;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.trgr.elasticMon.util.files.FileLoader;
import com.trgr.elasticMon.util.files.FileReader;
import com.trgr.elasticMon.util.files.FileReaderBase;

public class ConfigPropRead {
	private static Properties prop;
	private FileInputStream fileIn;
	private final FileReaderBase loadRoot;
	
	//private final String file;
	private String propLoaded=this.getClass().getName()+".loaded";
	
	public ConfigPropRead(final Object obj, final String fileName){
		loadRoot=new FileReader();
		//file=System.getProperty("qc.Config.file", System.getProperty("base.filepath")+fileName);
		try {			
			fileIn=new FileInputStream(loadRoot.extractFilePath(obj, fileName));
		} catch (FileNotFoundException e) {
			org.junit.Assert.fail(e.getMessage());
		}		
	}
	
	public void loadConfigProp(){
		if(!(loadRoot.getProperty(propLoaded, "false").equals("true"))){
			prop=new Properties(System.getProperties());
			prop.setProperty(propLoaded, "true");
		}
		try {
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
		return System.getProperty(key);
	}
}

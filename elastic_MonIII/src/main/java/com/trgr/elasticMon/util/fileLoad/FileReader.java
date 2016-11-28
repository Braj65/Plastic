package com.trgr.elasticMon.util.fileLoad;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileReader extends FileReaderBase{
	
	private final String rootFileLoaded=this.getClass().getName()+".loaded";
	public FileReader(){
		if(!(getProperty(rootFileLoaded, "false").equals("true"))){
			String file=System.getProperty("qc.root.file","C:/Eclipse_Plastic/Plastic_MonIII/elastic_MonIII/root.properties");
			loadProperty(file);
		}
	}
	
	private void loadProperty(String filePath){
		final Properties props=new Properties(System.getProperties());
		InputStream ins=null;
		try{
			ins=new FileInputStream(filePath);
			props.load(ins);
			props.setProperty(rootFileLoaded, "true");
			System.setProperties(props);
		}catch(IOException e){
			org.junit.Assert.fail(e.getMessage());
		}finally{
			try {
				ins.close();
			} catch (IOException e) {
				org.junit.Assert.fail(e.getMessage());
			}
		}
	}

	@Override
	public String getProperty(String key, String userProvided) {
		return fLoader.getProperty(key, userProvided);
	}

	@Override
	public File extractFilePath(Object obj, String fileName) {
		return fLoader.extractFilePath(obj, fileName);
	}

	@Override
	public String extractFileContent(Object obj, String fileName) {
		return fLoader.extractFileContent(obj, fileName);
	}	

}

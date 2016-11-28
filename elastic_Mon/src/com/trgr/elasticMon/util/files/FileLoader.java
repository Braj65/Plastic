package com.trgr.elasticMon.util.files;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.zip.GZIPInputStream;

import com.trgr.elasticMon.config.properties.load.ConfigPropRead;

public class FileLoader implements FileLoaderBase{
	
	private String rootFileLoaded=this.getClass().getName()+".loaded";
	
	public FileLoader(){
		if(!(getProperty(rootFileLoaded, "false").equals("true"))){
			String file=System.getProperty("qc.root.file","C:\\Eclipse_Plastic\\Plastic_Mon\\elastic_Mon\\root.properties");
			loadPropertyFile(file);
		}			
	}
	
	private void loadPropertyFile(final String filePath){
		Properties prop=new Properties(System.getProperties());
		InputStream is=null;
		try{
			is=new FileInputStream(filePath);
			prop.load(is);
			prop.setProperty(rootFileLoaded, "true");
			System.setProperties(prop);
		}catch(IOException e){
			org.junit.Assert.fail(e.getMessage());
		}finally{
			try{
				is.close();
			}catch(IOException e){
				org.junit.Assert.fail(e.getMessage());
			}
		}
	}
	
	public String getProperty(final String key, final String userProvided){
		String className=this.getClass().getName();
		String value=System.getProperty(className+"."+key);
		if(value==null || "".equals(value.trim())){
			value=System.getProperty(key);
			if(value==null || "".equals(value.trim())){
				return userProvided;
			}
		}
		
		return value;
	}
	
	public File extractFilePath(Object obj, final String fileName){
		final String slash=File.separator;
		final String base=getProperty("base.filepath", "");
		final String value=getProperty(fileName, base);
		String className=obj.getClass().getName();
		className=className.replaceAll("\\.", Matcher.quoteReplacement(slash));
		String relativeFromClass="src\\com\\trgr\\elasticMon";
		relativeFromClass=relativeFromClass.replaceAll("\\$.*", "");
		int ind=className.lastIndexOf("elasticMon")+"elasticMon".length();
		className=className.substring(ind+1, className.lastIndexOf(slash));		
		final String parentFolder=base+slash+relativeFromClass+slash+className+slash+fileName;
		final String propertyFolder=base+slash+relativeFromClass+slash+"config"+slash+"properties"+slash+fileName;
		final String relative=base+slash+relativeFromClass+slash+"files"+slash+fileName;
		final String[] filePaths={base+slash+fileName, relative, parentFolder, propertyFolder, base+slash+value, value};
		for(String cur: filePaths){
			File rc=new File(cur);
			if(rc.exists() && !rc.isDirectory())
				return rc;
		}
		org.junit.Assert.fail("Property "+fileName+" didn't map to a file for "+filePaths.toString());
		return null;
		
	}
	
	public String extractFileContent(Object obj, final String fileName){
		File f=extractFilePath(obj, fileName);
		String docLine;
		StringBuilder sb = new StringBuilder();
        FileInputStream fis = null;
        try {
                       fis = new FileInputStream(f);
        } catch (FileNotFoundException e) {
        	org.junit.Assert.fail(e.getMessage());
        }
        BufferedInputStream bis = new BufferedInputStream(fis);
        InputStreamReader isr = null;
        try {
                       isr = new InputStreamReader(bis);
        } catch (Exception e) {
        	org.junit.Assert.fail(e.getMessage());
        }
        BufferedReader br = new BufferedReader(isr);
        try {
			while((docLine=br.readLine())!=null){
				sb.append(docLine);
				sb.append("\n");
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        return sb.toString().trim();
	}
}

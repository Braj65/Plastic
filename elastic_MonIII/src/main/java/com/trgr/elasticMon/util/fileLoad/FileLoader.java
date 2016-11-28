package com.trgr.elasticMon.util.fileLoad;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;

public class FileLoader implements FileLoaderBase{
	
	

	@Override
	public String getProperty(final String key, final String userProvided) {
		String className=this.getClass().getName();
		String value=System.getProperty(className+"."+key);
		if(value==null || "".equals(value.trim())){
			value=System.getProperty(key);
			if(value==null || "".equals(value.trim()))
				return userProvided;
		}
		return value;
	}

	@Override
	public File extractFilePath(final Object obj, final String fileName) {
		final String slash=File.separator;
		final String base=getProperty("base.filepath","");
		final String value=getProperty(fileName, base);
		String className=obj.getClass().getName();
		className=className.replaceAll("\\.", Matcher.quoteReplacement(slash));
		int ind=className.lastIndexOf("elasticMon")+"elasticMon".length();
		className=className.substring(ind+1, className.lastIndexOf(slash));
		String relativeMainFromClass="src/main/java/com/trgr/elasticMon";
		relativeMainFromClass=relativeMainFromClass.replaceAll("\\$.*", "");
		String relativeTestFromClass="src/test/java/com/trgr/elasticMon";
		relativeTestFromClass=relativeTestFromClass.replaceAll("\\$.*", "");
		
		final String parentMainFolder=base+slash+relativeMainFromClass+slash+className+slash+fileName;
		final String parentTestFolder=base+slash+relativeTestFromClass+slash+className+slash+fileName;
		final String propertyFolder=base+slash+relativeMainFromClass+slash+"config/properties"+slash+fileName;
		final String relativeMain=base+slash+relativeMainFromClass+slash+"files"+slash+fileName;
		final String relativeTest=base+slash+relativeTestFromClass+slash+"files"+slash+fileName;
		
		final String[] filePaths={base+slash+fileName, relativeMain, relativeTest, parentMainFolder, parentTestFolder, propertyFolder, base+slash+value, value};
		for(String x: filePaths){
			File rc=new File(x);
			if(rc.exists() && !rc.isDirectory())
				return rc;
		}
		org.junit.Assert.fail("Property "+fileName+" didn't map to any file for "+filePaths.toString());
		return null;
	}

	@Override
	public String extractFileContent(final Object obj, final String fileName) {
		File f=extractFilePath(obj, fileName);
		String docLine;
		StringBuilder sb=new StringBuilder();
		/*FileInputStream fis=null;
		try{
			fis=new FileInputStream(f);
		}catch(FileNotFoundException e){
			org.junit.Assert.fail(e.getMessage());
		}
		BufferedInputStream bis=new BufferedInputStream(fis);
		InputStreamReader is=null;
		try{
			is=new InputStreamReader(bis);
		}catch(Exception e){
			org.junit.Assert.fail(e.getMessage());
		}
		BufferedReader br=new BufferedReader(is);
		try{
			while((docLine=br.readLine())!=null){
				sb.append(docLine.trim());
				sb.append("\n");
			}
		}catch(IOException e){
			org.junit.Assert.fail(e.getMessage());
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				org.junit.Assert.fail(e.getMessage());
			}
		}*/
		FileReader fr=null;
		try {
			fr=new FileReader(f);
		} catch (FileNotFoundException e) {
			org.junit.Assert.fail(e.getMessage());
		}
		BufferedReader bfr=new BufferedReader(fr);
		try{
			while((docLine=bfr.readLine())!=null){
				sb.append(docLine.trim());
				sb.append("\n");
			}
		}catch(IOException e){
			org.junit.Assert.fail(e.getMessage());
		}
		
		return sb.toString().trim();
	}

}

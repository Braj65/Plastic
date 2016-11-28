package com.trgr.elasticMon.util.property;

import com.trgr.elasticMon.util.files.FileReader;
import com.trgr.elasticMon.util.files.FileReaderBase;
import com.trgr.elasticMon.util.logs.Log;

public class Property {
	
	public enum Value{
		HOME_BASE("base.filepath", new FileReader().getProperty("base.filepath", ""));
		private final String property;
		private final String defaultValue;
		private String value=null;
		
		private Value(String property, String defaultValue){
			this.property=property;
			this.defaultValue=defaultValue;
		}
		
		public String getString(){
			if(value==null){
				if(defaultValue==null){
					value=System.getProperty(property);
				}else{
					value=System.getProperty(property, defaultValue);
				}
				Log.debug("property={} value={} "+property+" "+value);
			}
			return value;
		}
	}
	
	
}

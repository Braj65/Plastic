package com.trgr.elasticMon.util.property;

import com.trgr.elasticMon.util.fileLoad.FileReader;

public class Property {
	
	public enum Value{
		HOME_BASE("base.filepath", System.getProperty("base.filepath", "")),
		DATA_FILE("data.filepah", System.getProperty("data.filepath", ""));
		
		private final String property;
		private final String defaultVal;
		private String val=null;
		
		private Value(String prop, String defaultVal){
			this.property=prop;
			this.defaultVal=defaultVal;
		}
		
		public String getString(){
			if(val==null){
				if(defaultVal==null){
					val=System.getProperty(property);
				}else{
					val=System.getProperty(property, defaultVal);
				}
			}
			return val;
		}
	}

}

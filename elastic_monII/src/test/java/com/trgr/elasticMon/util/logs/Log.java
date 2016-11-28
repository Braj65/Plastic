package com.trgr.elasticMon.util.logs;

import org.apache.log4j.Logger;

public class Log {
	private static Logger Log=Logger.getLogger("devpinoyLogger");
	
	public static void startTestCase(String testCaseName){
		Log.debug("****************************************************************************************");
		Log.debug("$$$$$$$$$$$$$$$$$$$$$                 "+testCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
		Log.debug("****************************************************************************************");
	}
	
	public static void endTestCase(String testCaseName){
		Log.debug("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
	}
	
	public static void info(String message) {
		 Log.info(message);
	}
		  
	public static void warn(String message) {
		Log.warn(message);
	}
		  
	public static void error(String message) {
		Log.error(message);
	}
		  
	public static void fatal(String message) {
		Log.fatal(message);
	}
		  
	public static void debug(String message) {
		Log.debug(message);
	}
}

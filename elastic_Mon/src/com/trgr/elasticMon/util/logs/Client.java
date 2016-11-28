package com.trgr.elasticMon.util.logs;

public class Client {
	public static void main(String[] args){
		Log.startTestCase("Jammy");
		Log.info("Jammer");
		Log.debug("Jam");
		Log.error("Kram");
		Log.endTestCase("Semi");
	}

}

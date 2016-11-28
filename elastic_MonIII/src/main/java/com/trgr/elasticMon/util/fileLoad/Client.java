package com.trgr.elasticMon.util.fileLoad;

public class Client {	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException{
		FileReaderBase fb=new FileReader();
		System.out.println(fb.extractFileContent(Client.class.newInstance(), "Jam.txt"));
		
	}
}

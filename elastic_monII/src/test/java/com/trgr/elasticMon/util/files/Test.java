package com.trgr.elasticMon.util.files;

public class Test {
	public static void main(String[] args) throws Exception, Exception{
		Test t=new Test();
		System.out.println(t.getClass().getName());
		FileReaderBase r=new FileReader();
		System.out.println(r.extractFileContent(Test.class.newInstance(), "Test1.txt"));
	}
}

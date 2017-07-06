package com.trgr.elasticMon.util.xlsReader;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.trgr.elasticMon.util.fileLoad.FileReader;
import com.trgr.elasticMon.util.fileLoad.FileReaderBase;

public class Client {
	private Logger log=Logger.getLogger(Client.class);
	public static void main(String[] args) throws InstantiationException, IllegalAccessException{
		Client.class.newInstance().jam();
	}
	
	public void jam(){
		//FileReaderBase fb=new FileReader();
		//File f=fb.extractFilePath(this, "TestScenario1.xlsx");
		XLSX_reader xl;
		try{
			xl=new XLSX_reader("TestScenario1.xlsx");
			System.out.println(xl.getColumnCount("Test_Cases"));
			System.out.println(xl.getRowCount("Test_Cases"));
			log.info("Jammy");
			Map<Integer, List<Integer>> om=xl.getTestCaseRows("RegistrationTest");
			xl.getTestData("RegistrationTest");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
}

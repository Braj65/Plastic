package com.trgr.elasticMon.util.testUtils;


import java.util.Map;

import com.trgr.elasticMon.util.fileLoad.FileReader;
import com.trgr.elasticMon.util.property.Property;
import com.trgr.elasticMon.util.xlsReader.XLSX_reader;

public class TestDataUtil extends TestDataAbs{
	
	public TestDataUtil(){
		new FileReader();
		xlRead=this.getReader();
	}
	
	public static TestDataAbs getInstance(){
		if(testDataUtil==null)
			return testDataUtil=new TestDataUtil();
		else
			return testDataUtil;
	}

	@Override
	public boolean getSkipMode(Object obj) {
		return xlRead.getSkipMode(obj);
	}

	@Override
	public Object[][] getTestData(String className) {
		return xlRead.getTestData(className);
	}

}

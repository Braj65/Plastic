package com.trgr.elasticMon.util.testUtils;

import com.trgr.elasticMon.util.property.Property;
import com.trgr.elasticMon.util.xlsReader.XLReaderImpl;
import com.trgr.elasticMon.util.xlsReader.XLSX_reader;

public abstract class TestDataAbs {
	public abstract boolean getSkipMode(Object obj);
	public abstract Object[][] getTestData(String className);
	public XLReaderImpl getReader(){
		return new XLSX_reader(Property.Value.DATA_FILE.getString());
	}
	public static TestDataAbs testDataUtil=null;
	public XLReaderImpl xlRead;
}

package com.trgr.elasticMon.util.xlsReader;

public interface XLReaderImpl {
	public abstract boolean getSkipMode(Object obj);
	public abstract Object[][] getTestData(String testCaseName);
}

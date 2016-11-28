package com.trgr.elasticMon.util.files;

import java.io.File;

public interface FileReaderBase extends FileLoaderBase{
	//public void Construct();
	public String getProperty(String key, String userProvided);
	public File extractFilePath(Object obj, String fileName);
	public String extractFileContent(Object obj, String fileName);	
}

package com.trgr.elasticMon.util.files;

import java.io.File;

public interface FileReaderBase extends FileLoaderBase{
	//public void Construct();
	public String getProperty(final String key, final String userProvided);
	public File extractFilePath(final Object obj, final String fileName);
	public String extractFileContent(final Object obj, final String fileName);	
}

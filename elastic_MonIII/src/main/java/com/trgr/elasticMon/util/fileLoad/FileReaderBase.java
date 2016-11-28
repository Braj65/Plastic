package com.trgr.elasticMon.util.fileLoad;

import java.io.File;

public abstract class FileReaderBase implements FileLoaderBase{
	protected FileLoaderBase fLoader;
	public FileReaderBase(){
		fLoader=new FileLoader();
	}
	
	public abstract String getProperty(final String key, final String userProvided);
	public abstract File extractFilePath(final Object obj, final String fileName);
	public abstract String extractFileContent(final Object obj, final String fileName);
	
}

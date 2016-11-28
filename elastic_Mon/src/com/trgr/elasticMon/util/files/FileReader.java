package com.trgr.elasticMon.util.files;

import java.io.File;

public class FileReader implements FileReaderBase{
	FileLoaderBase fl=new FileLoader();

	@Override
	public String getProperty(String key, String userProvided) {
		return fl.getProperty(key, userProvided);
		
	}

	@Override
	public File extractFilePath(Object obj, String fileName) {
		return fl.extractFilePath(obj, fileName);
	}

	@Override
	public String extractFileContent(Object obj, String fileName) {
		return fl.extractFileContent(obj, fileName);
	}
	
	
}

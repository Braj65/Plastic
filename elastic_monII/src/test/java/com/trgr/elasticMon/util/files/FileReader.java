package com.trgr.elasticMon.util.files;

import java.io.File;

public class FileReader implements FileReaderBase{
	final FileLoaderBase fl=new FileLoader();

	@Override
	public String getProperty(final String key, final String userProvided) {
		return fl.getProperty(key, userProvided);
		
	}

	@Override
	public File extractFilePath(final Object obj, final String fileName) {
		return fl.extractFilePath(obj, fileName);
	}

	@Override
	public String extractFileContent(final Object obj, final String fileName) {
		return fl.extractFileContent(obj, fileName);
	}
	
	
}

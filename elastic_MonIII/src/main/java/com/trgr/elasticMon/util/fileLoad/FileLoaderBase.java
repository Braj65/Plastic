package com.trgr.elasticMon.util.fileLoad;

import java.io.File;

public interface FileLoaderBase {
	public String getProperty(final String key, final String userProvided);
	public File extractFilePath(final Object obj, final String fileName);
	public String extractFileContent(final Object obj, final String fileName);
}

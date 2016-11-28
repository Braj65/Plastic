package com.trgr.elasticMon.command;

import com.trgr.elasticMon.util.fileLoad.FileReader;
import com.trgr.elasticMon.util.fileLoad.FileReaderBase;

public class FileLoader {
	
	public FileReaderBase Action(){
		return new FileReader();
	}

}

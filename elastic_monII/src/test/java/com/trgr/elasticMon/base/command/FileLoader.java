package com.trgr.elasticMon.base.command;

import com.trgr.elasticMon.util.files.FileReader;
import com.trgr.elasticMon.util.files.FileReaderBase;

public class FileLoader {
	
	public FileReaderBase Action(){
		FileReaderBase r=new FileReader();
		return r;
	}

}

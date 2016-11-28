package com.trgr.elasticMon.base.command;

public class FileLoaderBase extends Command{

	private FileLoader myFileLoader;
	public FileLoaderBase(FileLoader rece) {
		myFileLoader=rece;
	}

	@Override
	public Object execute() {
		return myFileLoader.Action();	
	}

	@Override
	public Object execute(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}

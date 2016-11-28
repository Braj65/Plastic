package com.trgr.elasticMon.command;

public class FileLoaderBase implements Command{

	private final FileLoader myFileLoader;
	public FileLoaderBase(FileLoader rece){
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

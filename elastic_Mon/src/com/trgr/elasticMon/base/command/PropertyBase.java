package com.trgr.elasticMon.base.command;

public class PropertyBase extends Command{

	private Property myProperty;
	public PropertyBase(Property rece) {
		myProperty=rece;
	}

	@Override
	public Object execute(Object obj) {
		return myProperty.Action(obj);		
	}

	@Override
	public Object execute() {
		// TODO Auto-generated method stub
		return null;
	}

}

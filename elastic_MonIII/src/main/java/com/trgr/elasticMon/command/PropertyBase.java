package com.trgr.elasticMon.command;

public class PropertyBase implements Command{

	private final Property myProperty;
	public PropertyBase(Property rece){
		myProperty=rece;
	}
	@Override
	public Object execute() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object execute(final Object obj) {
		return myProperty.Action(obj);
	}

}

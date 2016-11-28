package com.trgr.elasticMon.base.command;

public class PropertyBase extends Command{

	private final Property myProperty;
	public PropertyBase(Property rece) {
		myProperty=rece;
	}

	@Override
	public Object execute(final Object obj) {
		return myProperty.Action(obj);		
	}

	@Override
	public Object execute() {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.trgr.elasticMon.command;

public interface Command {
	public Object execute();
	public Object execute(Object obj);
}

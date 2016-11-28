package com.trgr.elasticMon.util.property;

public class Client {
	
	enum choice{
		Choice1,
		Choice2
	}
	public choice jam=choice.Choice1;
	public static void main(String[] args){
		System.out.println(Property.Value.HOME_BASE.getString());
		System.out.println(choice.Choice1);
	}
}

package com.trgr.elasticMon.base.command;

public class Client {
	public static void main(String[] args){
		Processor p=new Processor();
		try {
			p.run(Client.class.newInstance());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package com.trgr.elasticMon.command;

public class ClientX {
	public static void main(String[] args){
		Processor p=new Processor();
		try {
			p.run(Class.forName("com.trgr.elasticMon.command.ClientX"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.getComp().getService().getDriver().get("http://www.google.co.uk");
	}
}

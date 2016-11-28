package com.trgr.elasticMon.command;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Client {
	ProcessorConsumerAbs proc=null;
	public static void main(String[] args){
		/*Injector injector=Guice.createInjector(new AppInjector());
		ProcessorConsumerAbs proc=injector.getInstance(ProcessorConsumer.class);
		try {
			proc.run(Client.class.newInstance());
		} catch (InstantiationException | IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		ProcessorConsumerAbs proc=new ProcessorConsumer();
		try {
			proc.run(Class.forName("com.trgr.elasticMon.command.Client"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*ProcessorService p=new ProcessorService();
		try {
			p.run(Client.class.newInstance());
			
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	public void jam(){
		Injector injector=Guice.createInjector(new ProcesssorInjector());
		proc=injector.getInstance(ProcessorConsumer.class);
	}
	public void run(){
		try {
			proc.run(Class.forName("com.trgr.elasticMon.command.Client"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

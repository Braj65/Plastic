package com.trgr.elasticMon.command;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Processor {
	private ProcessorConsumerAbs proc=null;
	public Processor(){
		Injector injector=Guice.createInjector(new ProcesssorInjector());
		proc=injector.getInstance(ProcessorConsumer.class);
	}
	
	public void run(final Object obj){
		proc.run(obj);
	}
	
	public ProcessorConsumerAbs getComp(){
		return proc;
	}
}

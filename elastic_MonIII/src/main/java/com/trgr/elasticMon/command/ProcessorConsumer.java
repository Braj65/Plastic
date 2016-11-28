package com.trgr.elasticMon.command;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

public class ProcessorConsumer implements ProcessorConsumerAbs{
	private ProcessorServiceAbs service;
	
	/*@Inject
	public ProcessorConsumer(ProcessorServiceAbs serv){
		this.service=serv;
		//this.createAndBind();
	}*/
	/*public ProcessorConsumer(){
		this.createAndBind();
	}*/
	
	@Inject
	public void setService(ProcessorServiceAbs serv){
		this.service=serv;
	}

	@Override
	public void run(Object obj) {
		service.run(obj);		
	}
	
	public ProcessorServiceAbs getService(){
		return this.service;
	}
	
	/*public void createAndBind(){
		ProcessorConsumerAbs proc=Guice.createInjector(new AbstractModule(){
			@Override
			protected void configure() {
				bind(ProcessorServiceAbs.class).to(ProcessorService.class).in(Singleton.class);
			}			
		}).getInstance(ProcessorConsumer.class);
		
		Injector injector=Guice.createInjector(new ProcesssorInjector());
		ProcessorConsumerAbs proc=injector.getInstance(ProcessorConsumer.class);
	}*/
	
}

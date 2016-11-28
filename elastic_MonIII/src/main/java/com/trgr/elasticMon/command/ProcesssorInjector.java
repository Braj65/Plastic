package com.trgr.elasticMon.command;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class ProcesssorInjector extends AbstractModule{

	@Override
	protected void configure() {
		bind(ProcessorServiceAbs.class).to(ProcessorService.class).in(Singleton.class);	
	}	
}

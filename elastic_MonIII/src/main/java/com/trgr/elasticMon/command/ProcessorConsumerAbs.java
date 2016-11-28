package com.trgr.elasticMon.command;

public interface ProcessorConsumerAbs {
	void run(final Object obj);
	ProcessorServiceAbs getService();
}

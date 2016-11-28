package com.trgr.elasticMon.processor;

import com.trgr.elasticMon.base.DriverProductBase;

public interface ProcessorServiceAbs {
	void run(final Object obj);
	DriverProductBase getDriver();

}

package com.trgr.elasticMon.command;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.trgr.elasticMon.config.properties.load.ConfigProps;
import com.trgr.elasticMon.pages.ConcreteVisitor;
import com.trgr.elasticMon.util.fileLoad.FileReaderBase;

public interface ProcessorServiceAbs {
	void run(final Object obj);
	EventFiringWebDriver getDriver();
	ConfigProps getProps();
	FileReaderBase getFileRead();
	Pages getPages();
	ConcreteVisitor getPgVisit();
}

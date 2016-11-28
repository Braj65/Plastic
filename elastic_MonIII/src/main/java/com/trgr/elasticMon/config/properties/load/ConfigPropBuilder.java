package com.trgr.elasticMon.config.properties.load;

public abstract class ConfigPropBuilder {
	
	public abstract ConfigPropBuilder setFilePath(String file);
	public abstract ConfigPropBuilder setPropertyFile(Object obj);
	public abstract ConfigPropBuilder buildConfigProp();
	public abstract ConfigPropRead build();
}

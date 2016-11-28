package com.trgr.elasticMon.config.properties.load;


public class ConfigPropConcreteBuilder extends ConfigPropBuilder{
	private String file="//src//com//trgr//elasticMon//config//properties//config.properties";
	private ConfigPropRead confRead;

	@Override
	public ConfigPropBuilder setConfigPath(String file) {
		this.file=file;
		return this;
	}
	
	@Override
	public ConfigPropBuilder setPropertyFile(Object obj) {
		confRead=new ConfigPropRead(obj, file);
		return this;
	}

	@Override
	public ConfigPropBuilder buildConfigProp() {
		confRead.loadConfigProp();
		return this;
	}

	@Override
	public ConfigPropRead build() {
		return confRead;
	}	
}

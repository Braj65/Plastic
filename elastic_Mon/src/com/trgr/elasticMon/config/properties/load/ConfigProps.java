package com.trgr.elasticMon.config.properties.load;

public class ConfigProps {
	
	ConfigPropBuilder props=new ConfigPropConcreteBuilder();
	ConfigPropRead pr;
	String file;
	public ConfigProps(Object obj, String file){
		this.file=file;
		props=Construct(obj, props, file);
	}
	private ConfigPropBuilder Construct(Object obj, ConfigPropBuilder build, String file){
		return build.setConfigPath(file).setPropertyFile(obj).buildConfigProp();
	}
	
	public String getProp(String key){
		return props.build().getConfigProp(key);
	}
	
	public ConfigPropBuilder addFile(Object obj, String file){
		return props.setConfigPath(file).setPropertyFile(obj).buildConfigProp();
	}
}

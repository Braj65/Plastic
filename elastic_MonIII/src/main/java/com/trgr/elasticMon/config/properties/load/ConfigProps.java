package com.trgr.elasticMon.config.properties.load;

public class ConfigProps {
	
	ConfigPropBuilder props=new ConfigPropBuilder(){
		private String file="/src/main/java/com/trgr/elasticMon/config/properties/config.properties";
		private ConfigPropRead cprRead;
		@Override
		public ConfigPropBuilder setFilePath(final String file) {
			this.file=file;
			return this;
		}

		@Override
		public ConfigPropBuilder setPropertyFile(Object obj) {
			cprRead=new ConfigPropRead(obj, file);
			return this;
		}

		@Override
		public ConfigPropBuilder buildConfigProp() {
			cprRead.loadConfigProp();
			return this;
		}

		@Override
		public ConfigPropRead build() {
			return cprRead;
		}		
	};
	
	String file;	
	public ConfigProps(final Object obj, final String file){
		this.file=file;
		props=Construct(props, obj, file);		
	}
	
	public ConfigPropBuilder Construct(ConfigPropBuilder prop, final Object obj, String file){
		return prop.setFilePath(file).setPropertyFile(obj).buildConfigProp();
	}
	
	public String getProperty(String key){
		return props.build().getConfigProp(key);
	}
	
	public ConfigPropBuilder addFile(final Object obj, String file){
		return props.setFilePath(file).setPropertyFile(obj).buildConfigProp();
	}
}

package com.trgr.elasticMon.config.properties.load;

public class ConfigProps {
	
	ConfigPropBuilder props=new ConfigPropBuilder(){
		private String file="//src//com//trgr//elasticMon//config//properties//config.properties";
		private ConfigPropRead confRead;

		@Override
		public ConfigPropBuilder setConfigPath(final String file) {
			this.file=file;
			return this;
		}
		
		@Override
		public ConfigPropBuilder setPropertyFile(final Object obj) {
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
	};
	ConfigPropRead pr;
	String file;
	public ConfigProps(final Object obj, final String file){
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

package com.naveenautomationlab.AutomationFramework.Utils;

public enum Environment {
	
	DEV("Dev","https://naveenautomationlabsdev.com/opencart/index.php?route=common/home"),
	STAGE("Stage","https://naveenautomationlabsdevstage.com/opencart/index.php?route=common/home"),
	QA("QA","https://naveenautomationlabsdevqa.com/opencart/index.php?route=common/home"),
	PROD("Prod","https://naveenautomationlabs.com/opencart/index.php?route=common/home");
	
	String env;
	String url;
	
	private Environment(String env,String URL) {
		
		this.env=env;
		url=URL;
	
	}

	public String getEnv() {
		return env;
	}

	public String getUrl() {
		return url;
	}

}

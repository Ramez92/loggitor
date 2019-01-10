package com.log.loggitor.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class App {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long AppID;
	private String AppName,AppType;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="app")
	private List<DefectInstance> defeInstance;
	public App() {
		super();
	}

	public App(String appName, String appType) {
		super();
		AppName = appName;
		AppType = appType;
	}

	public String getAppName() {
		return AppName;
	}

	public void setAppName(String appName) {
		AppName = appName;
	}

	public String getAppType() {
		return AppType;
	}

	public void setAppType(String appType) {
		AppType = appType;
	}

	public List<DefectInstance> getDefeInstance() {
		return defeInstance;
	}

	public void setDefeInstance(List<DefectInstance> defeInstance) {
		this.defeInstance = defeInstance;
	}
	
}

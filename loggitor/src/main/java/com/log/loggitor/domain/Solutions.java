package com.log.loggitor.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Solutions {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long Sol_id;
	private String SolName,SolDescription;
	
	public Solutions() {
		super();
	}
	
	public Solutions(String solName, String solDescription) {
		super();
		SolName = solName;
		SolDescription = solDescription;
	}

	public String getSolName() {
		return SolName;
	}
	public void setSolName(String solName) {
		SolName = solName;
	}
	public String getSolDescription() {
		return SolDescription;
	}
	public void setSolDescription(String solDescription) {
		SolDescription = solDescription;
	}
	
}

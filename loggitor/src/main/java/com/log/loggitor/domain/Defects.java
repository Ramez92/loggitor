package com.log.loggitor.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Defects {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long Def_id;
	private String Severity,error_code,D_sol;
	public Defects() {
		super();
	}
	public Defects(String d_sol,String severity, String error_code) {
		super();
		Severity = severity;
		this.error_code = error_code;
		D_sol = d_sol;
	}

	public String getSeverity() {
		return Severity;
	}
	public void setSeverity(String severity) {
		Severity = severity;
	}
	public String getError_code() {
		return error_code;
	}
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	public String getD_sol() {
		return D_sol;
	}
	public void setD_sol(String d_sol) {
		D_sol = d_sol;
	}
	
}

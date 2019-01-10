package com.log.loggitor.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LogFile {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long FileID;
	private String FileName;
	private Date Date_Time;
	
	public LogFile() {
		super();
	}

	public LogFile(String fileName, Date date_Time) {
		super();
		FileName = fileName;
		Date_Time = date_Time;
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public Date getDate_Time() {
		return Date_Time;
	}

	public void setDate_Time(Date date_Time) {
		Date_Time = date_Time;
	}
	
	
}

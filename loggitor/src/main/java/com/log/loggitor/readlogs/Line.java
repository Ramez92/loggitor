package com.log.loggitor.readlogs;
import java.util.regex.Pattern;

public class Line {

	private String content = null;
	private String applicationName = null;
	//1 is core otherwise custom
	private String applicationType = null;
	//6 digits
	private String errorCode = null;
	
	private String severity = null;
	
	private String solution = null;
	
	
	public Line() {
		super();	
	}
	
	
	public Line(String content) {
		super();
		this.content = content;
		if(content.contains("Caused by:")) {
			processContent() ;
		}
		
	}
	
	public Line(String content, String applicationName, String applicationType, String errorCode) {
		super();
		this.content = content;
		this.applicationName = applicationName;
		this.applicationType = applicationType;
		this.errorCode = errorCode;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getApplicationName() {
		return applicationName;
	}
	private void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public String getApplicationType() {
		return applicationType;
	}
	private void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}
	public String getErrorCode() {
		return errorCode;
	}
	private void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	

	public String getSolution() {
		return "this is temp solution";
	}


	public void setSolution(String solution) {
		this.solution = solution;
	}
	
	
	
	public String getSeverity() {
		return severity;
	}


	public void setSeverity() {
		
		if(getErrorCode() != null){
			int firstDigit = Integer.parseInt((getErrorCode()).substring(0, 1));
			
			if(firstDigit >=1 && firstDigit <=3 ) {
				this.severity = "Critical";
				return;
			}
			
			if(firstDigit >=4 && firstDigit <=6 ) {
				this.severity = "Error";
				return;
			}
			
			this.severity = "Warning";
			return;
			
		}
		
		
	}


	private void processContent() {
		try {
	    String regex = "(\\([a-zA-Z]{2}[a-zA-Z]?1?-\\d{6}\\))";
	    int index = MyHelper.indexOf(Pattern.compile(regex), getContent());
	    
	    //if the pattern was found
	    if(index >= 0) {
	    	String neededCode = getContent().substring(index,index + 12);
			neededCode = neededCode.replace('(', ' ');
			neededCode = neededCode.replace(')', ' ');
			neededCode = neededCode.replaceAll("\\s+","");
			String[] errorAndTypeCode = neededCode.split("-");
			setErrorCode(errorAndTypeCode[1]);
			setSeverity();
			setApplicationName(errorAndTypeCode[0].substring(0,errorAndTypeCode[0].length() -1));
			if(errorAndTypeCode[0].contains("1")) {
				setApplicationType("core");
			}
			else {
				setApplicationType("custom");
			}
	    }
		
		}
		catch(Exception e) {
			System.out.println("error while processing contetnt" + e);
		}
	}


	
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
				if(getContent()!=null) {
					buffer.append("Error message: ");
					buffer.append(getContent());
					buffer.append("\n");
				}
				
				if(getApplicationName()!=null) {
					buffer.append("Application Name: ");
					buffer.append(getApplicationName());
					buffer.append("\n");
				}
				
				if(getApplicationType()!=null) {
					buffer.append("Application Type: ");
					buffer.append(getApplicationType());
					buffer.append("\n");
				}
				
				if(getErrorCode()!=null) {
					buffer.append("Error code: ");
					buffer.append(getErrorCode());
					buffer.append("\n");
				}
				
				buffer.append("------------------");
				
				
		return buffer.toString();
	}
	
	
	
	
}

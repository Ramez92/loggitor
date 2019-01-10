package com.log.loggitor.readlogs;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;




public class Logwriter {

	private BufferedWriter writer = null;
	private static final String newLine = "\r\n";
	private ArrayList<Line> LinesList = null;
	
	
	public Logwriter(String fileName, ArrayList<Line> LinesList ){
		super();
		try {
			init(fileName, LinesList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
    public void init(String fileName, ArrayList<Line> LinesList) throws IOException {
		
		try {
			FileWriter fileWriter = new FileWriter(fileName);
			writer = new BufferedWriter(fileWriter);
			this.LinesList = LinesList;
			
		}
		catch(FileNotFoundException e) {
			System.out.println(e + " cncountered while initializing cash drawer writer");
			
		}
	
	}
    
    
    public void printAllErrorLines() {
    //StringBuffer buffer = new StringBuffer();
    	
    	if(LinesList.size() > 0) {
    		
    	
    	
    Iterator iterator = LinesList.iterator();
		
		while(iterator.hasNext()) {
			Line line = (Line)iterator.next();
			System.out.println(line);
		
		//	buffer.append("87");
			
		}
		
    	}
    	else
    	{
    		System.out.println("No error line were found in the log");
    		
    	}
		
		
    }
    
    
    
    public void numberOfErrorsPerApp() {
    	Map<String, Integer> appMap = new HashMap<String, Integer>();
    	
    	 Iterator iterator = LinesList.iterator();
 		
 		while(iterator.hasNext()) {
 			Line line = (Line)iterator.next();
 			String appName = line.getApplicationName();
 			
 			if(line.getApplicationName() != null) {
 				
 			
 			
 			if(!appMap.containsKey(appName)) {
 				appMap.put(appName, 1);
 			}
 			else
 			{
 				Integer counter = appMap.get(appName);
 				counter++;
 				appMap.remove(appName);
 				appMap.put(appName, counter);
 			}
 			}
 		}
 		
 		for (Map.Entry<String, Integer> entry : appMap.entrySet()) {
 		    System.out.println("Application: " + entry.getKey() + ": Number of defects at all: " + entry.getValue());
 		  
 		}
 			
 		
 		
    }
    
    
    public void numberOfErrorsPerSeverity() {
    	Map<String, Integer> severityCodeMap = new HashMap<String, Integer>();
    	
    	 Iterator iterator = LinesList.iterator();
 		
 		while(iterator.hasNext()) {
 			Line line = (Line)iterator.next();
 			String appName = line.getApplicationName();
 			String severity = line.getSeverity();
 			String applicationType = line.getApplicationType();
 			if(severity != null && appName!= null) {
 			
 			if(!severityCodeMap.containsKey(severity)) {
 				severityCodeMap.put(severity, 1);
 			}
 			else
 			{
 				Integer counter = severityCodeMap.get(severity);
 				counter++;
 				severityCodeMap.remove(severity);
 				severityCodeMap.put(severity, counter);
 			}
 			}
 			
 		}
 		
 		for (Map.Entry<String, Integer> entry : severityCodeMap.entrySet()) {
 		    System.out.println("By Severity Only - " + entry.getKey() + " : Number of errors: " + entry.getValue());
 		  
 		}
 			
 		
 		
    }
    
    
    
    public void numberOfErrorsPerAppSeverity() {
    	Map<String, Integer> severityCodeMap = new HashMap<String, Integer>();
    	
    	 Iterator iterator = LinesList.iterator();
 		
 		while(iterator.hasNext()) {
 			Line line = (Line)iterator.next();
 			String appName = line.getApplicationName();
 			String severity = line.getSeverity();
 			String applicationType = line.getApplicationType();
 			if(severity != null && appName!= null) {
 			
 			if(!severityCodeMap.containsKey(appName+"-"+applicationType+"-"+severity)) {
 				severityCodeMap.put(appName+"-"+applicationType+"-"+severity, 1);
 			}
 			else
 			{
 				Integer counter = severityCodeMap.get(appName+"-"+applicationType+"-"+severity);
 				counter++;
 				severityCodeMap.remove(appName+"-"+applicationType+"-"+severity);
 				severityCodeMap.put(appName+"-"+applicationType+"-"+severity, counter);
 			}
 			}
 			
 		}
 		
 		for (Map.Entry<String, Integer> entry : severityCodeMap.entrySet()) {
 		    System.out.println(entry.getKey() + " - Number of defects with " + entry.getKey().split("-")[2]+ " severity: "+ entry.getValue());
 		  
 		}
 			
 		closeWritter();
 		
    }
    
    
    
    public void numberOfErrorsPerErrorCode() {
    	Map<String, Integer> errorCodeMap = new HashMap<String, Integer>();
    	
    	 Iterator iterator = LinesList.iterator();
 		
 		while(iterator.hasNext()) {
 			Line line = (Line)iterator.next();
 			String appName = line.getApplicationName();
 			String errorCode = line.getErrorCode();
 			
 			if(errorCode != null && appName!= null) {
 			
 			if(!errorCodeMap.containsKey(appName+"-"+errorCode)) {
 				errorCodeMap.put(appName+"-"+errorCode, 1);
 			}
 			else
 			{
 				Integer counter = errorCodeMap.get(appName+"-"+errorCode);
 				counter++;
 				errorCodeMap.remove(appName+"-"+errorCode);
 				errorCodeMap.put(appName+"-"+errorCode, counter);
 			}
 			}
 			
 		}
 		
 		for (Map.Entry<String, Integer> entry : errorCodeMap.entrySet()) {
 		    System.out.println("Error Code: " + entry.getKey() + ", Number of errors: " + entry.getValue());
 		  
 		}
 			
 		
 		
    }
   
    public void closeWritter() {
    try {
			
			
			writer.flush();
			writer.close();
		}
		catch(IOException e) {
			System.out.println("Unable to close report file due to " + e);
			
		}
    }
	
}

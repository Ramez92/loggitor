package com.log.loggitor.readlogs;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class LogReader {

	private BufferedReader reader = null;
	private ArrayList<Line> LinesList = null;
	
	
	
	
	public LogReader(String fileName) {
		super();
		init(fileName);
		// TODO Auto-generated constructor stub
	}

	private void init(String fileName) {
		try {
			System.out.println("file name: " + fileName );
			FileReader fileReader = new FileReader(fileName);
			reader = new BufferedReader(fileReader);
		} catch (FileNotFoundException e) {
			
			System.out.println("error while reading file "+ e);
			
		}
		
	}
	
	private Line readLine() {
		Line line = null;
		try {
		
			String data = reader.readLine();
			if(data == null) {
				return line;
			}
			line = new Line(data);
			return line;
			}
			catch(IOException e) {
				System.out.println(e + " reding line encountered a problem.");
				return null;
			}
		
	}
	
	
	public void getAllLines() {
		LinesList = new ArrayList<Line>();
		Line line = null;
		
		try {
			do {
				
				line = readLine();
				if(line == null) {
					return;
				}
				else
				{
					if(line.getContent().contains("Caused by:")) {
						LinesList.add(line);
					}
					
				}
				
				
				
			}while(true);
		} catch (Exception e) {
			System.out.println(e + " encountered. Unable to process input file.");
			
		}
		finally {
			try {
				reader.close();
			}
			catch(IOException e) {
				System.exit(1);
			}
		}
	}

	public ArrayList<Line> getLinesList() {
		return LinesList;
	}
	
	
	

	
	
	
	
}

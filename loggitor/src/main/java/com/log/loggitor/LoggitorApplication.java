package com.log.loggitor;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.log.loggitor.domain.App;
import com.log.loggitor.repository.AppRepository;
import com.log.loggitor.domain.DefectInstance;
import com.log.loggitor.domain.Defects;
import com.log.loggitor.readlogs.Line;
import com.log.loggitor.readlogs.LogReader;
import com.log.loggitor.readlogs.Logwriter;
import com.log.loggitor.repository.DefectInstanceRepository;
import com.log.loggitor.repository.DefectsRepository;



@SpringBootApplication
public class LoggitorApplication {
	@Autowired
	private AppRepository repositoryAppTable;
	@Autowired
	private DefectInstanceRepository repDefectInstanceTable;
	@Autowired
	private DefectsRepository repDefTable;
	
	static ArrayList<Line> LinesList ;
	private static final Logger logger=LoggerFactory.getLogger(LoggitorApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(LoggitorApplication.class, args);
		
		
		
		
		//check
		logger.info("Check Logger !!!!!");
	}
	@Bean
	CommandLineRunner runner() {
		return args-> {
			
			ArrayList<Line> LinesList2 = getLogsError();
			repDefectInstanceTable.deleteAll();
			repDefTable.deleteAll();
			repositoryAppTable.deleteAll();
			for(Line b:LinesList2) {
			App app=new App(b.getApplicationName(),b.getSeverity());
			repositoryAppTable.save(app);
			
			Defects defects = new Defects(b.getSolution(), b.getSeverity(), b.getContent());
			repDefTable.save(defects);
			}
		/*
			App app1=new App("aaa","Custom");
			App app2=new App("bbb","Core");
			App app3=new App("ccc","Custom");
		repository1.save(app1);
		repository1.save(app2);
		repository1.save(app3);
		repository1.save(app4);
		rep.save(new DefectInstance(1,1,1,app1));
		rep.save(new DefectInstance(5,2,2,app2));
		rep.save(new DefectInstance(3,3,3,app3));
		repDef.save(new Defects("Critical", "00004", "ssss"));
		repDef.save(new Defects("Warning", "00036", "zzzz"));
		repDef.save(new Defects("Error", "00001", "aaaa"));
		
		*/
		};
	}
	
	
	public static ArrayList<Line> getLogsError(){

		//String fileName = "D:\\fullstuckCourse\\logsProject\\hasErrors\\CMServer.20170914_2028.log";
				String fileToWrite =  "D:\\fullstuckCourse\\logsProject\\hasErrors\\outPut.txt";
				String fileName = "D:\\fullstuckCourse\\logsProject\\fromMohamad\\CMServer.20170914_2028.log";
				LogReader logReader = new LogReader(fileName);
				logReader.getAllLines();
				
				Logwriter logwriter = new Logwriter(fileToWrite, logReader.getLinesList());
		
				logwriter.numberOfErrorsPerApp();
				logwriter.numberOfErrorsPerErrorCode();
				logwriter.numberOfErrorsPerSeverity();
				logwriter.numberOfErrorsPerAppSeverity();
				
				LinesList = logReader.getLinesList();
				System.out.println("get application name: "+LinesList.get(0).getApplicationName());
		return LinesList;
	}
	

}


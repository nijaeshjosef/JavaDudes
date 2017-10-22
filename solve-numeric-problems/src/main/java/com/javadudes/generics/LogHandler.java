package com.javadudes.generics;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogHandler {
	
	public static Logger getLogger(Logger logger, String className) 
	{
		
		try {
			
			//Setting up the logger
			logger = Logger.getLogger(className);
			
			//Setting up file Handler
			FileHandler fh = new FileHandler("D:/Java Dudes/logs/solve-numeric-problems.log");
			logger.addHandler(fh);
			
			//Setting formatter
			SimpleFormatter simpleformatter = new SimpleFormatter();
			fh.setFormatter(simpleformatter);

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return logger;
	}
}

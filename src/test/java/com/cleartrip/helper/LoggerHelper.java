/**
 * 
 */
package com.cleartrip.helper;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author Sonam_Mittal
 *
 */

public class LoggerHelper {

private static boolean root=false;

	public static Logger getLogger(Class cls){

		System.out.println(cls.getName());
		if(root){

			return Logger.getLogger(cls);

		}

		//PropertyConfigurator.configure(System.getProperty("user.dir")+"\\log4j.properties");
		//PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\log4j.properties");
		PropertyConfigurator.configure("log4j.properties");
		
		System.out.println(System.getProperty("user.dir")+"\\src\\test\\resources\\log4j.properties");
		root = true;

		return Logger.getLogger(cls);

	}

	public static void main(String[] args) {

		Logger log = LoggerHelper.getLogger(LoggerHelper.class);

		log.info("I am test");

		log.info("I am test");

		log.info("I am test");

	}
}

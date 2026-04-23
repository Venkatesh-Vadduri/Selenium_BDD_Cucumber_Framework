package com.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoggerManager {

    //This method returns the logger instance of provided class
    public static Logger getLogger(Class<?> clazz) {
       return  LogManager.getLogger();

    }


}

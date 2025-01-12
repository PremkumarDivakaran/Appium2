package com.saucelab.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FrameworkLogger {

    private static final Logger logger = LogManager.getLogger(FrameworkLogger.class);

    private FrameworkLogger(){}

    public static void info(String msg){
        logger.info(msg);
    }

    public static void warn(String msg){
        logger.warn(msg);
    }

    public static void error(String msg){
        logger.error(msg);
    }

    public static void debug(String msg){
        logger.debug(msg);
    }

}

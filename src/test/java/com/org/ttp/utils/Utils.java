package com.org.ttp.utils;

import com.org.ttp.glue.CommonStep;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

public class Utils {
    public static final Logger logger = LogManager.getLogger(Utils.class);
    public  void loadProperties(){
        logger.info("Class:Utils--Method:loadProperties()--started");
        Properties properties = new Properties();
        try {
            properties.load(Utils.class.getResourceAsStream("/config.properties"));
            AllConstants.APP_URL.setValue(properties.getProperty("APP_URL"));
            AllConstants.BROWSER.setValue(properties.getProperty("BROWSER"));
            AllConstants.TESTDATA_FILENAME.setValue(properties.getProperty("TESTDATA_FILENAME"));
            AllConstants.TESTDATA_FILEPATH.setValue(properties.getProperty("TESTDATA_FILEPATH"));
            AllConstants.TEXT_FILENAME.setValue(properties.getProperty("TEXT_FILENAME"));
            AllConstants.IMAGE_FILENAME.setValue(properties.getProperty("IMAGE_FILENAME"));
        }catch(Exception e){
            logger.error(e.getMessage());
        }
        logger.info("Class:Utils--Method:loadProperties()--ended");
    }
}

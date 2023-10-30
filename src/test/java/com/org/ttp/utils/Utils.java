package com.org.ttp.utils;

import java.util.Properties;

public class Utils {
    public  void loadProperties(){
        Properties properties = new Properties();
        try {

            properties.load(Utils.class.getResourceAsStream("/config.properties"));

            AllConstants.APP_URL.setValue(properties.getProperty("APP_URL"));
            AllConstants.BROWSER.setValue(properties.getProperty("BROWSER"));
            AllConstants.TESTDATA_FILENAME.setValue(properties.getProperty("TESTDATA_FILENAME"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

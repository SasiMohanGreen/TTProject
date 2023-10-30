package com.org.ttp.utils;

import java.io.File;

public enum AllConstants {

    EDGE_DRIVER("webdriver.ie.driver"),


    SYSTEM_PATH(System.getProperty("user.dir") + File.separator),

    BROWSER(),

    APP_URL(),

    TESTDATA_FILENAME(),
    TESTCASE_ID();


    private String value;
    private AllConstants(){

    }
    private AllConstants(String value){
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}

package com.org.ttp.utils;

import java.io.File;
import com.org.ttp.pojo.TTFormTestData;

public enum AllConstants {

    SYSTEM_PATH(System.getProperty("user.dir") + File.separator),

    BROWSER(),

    APP_URL(),

    TESTDATA_FILENAME(),

    TESTDATA_FILEPATH(),

    TTFormTestData(),

    TEXT_FILENAME(),

    IMAGE_FILENAME(),
    TESTCASE_ID();

    private String value;
    private TTFormTestData objValue;
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
    public void setObjectValue(TTFormTestData obj) {
        this.objValue = obj;
    }
    public TTFormTestData getObjectValue() {
        return objValue;
    }

}

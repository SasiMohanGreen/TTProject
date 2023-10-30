package com.org.ttp.glue;

import com.org.ttp.pojo.TTFormTestData;
import com.org.ttp.utils.AllConstants;
import com.org.ttp.utils.ReadTestData;
import com.org.ttp.utils.Utils;
import com.org.ttp.utils.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class CommonBeforeStep {
    public static WebDriver driver;

    private static boolean firstTimeAppLaunch = true;

    private static final Logger logger = LogManager.getLogger(CommonBeforeStep.class);

    public static TTFormTestData testDataObj ;

    @Before
    public void commonBeforeSteps(Scenario scenario){
        try {
            AllConstants.TESTCASE_ID.setValue(getTestcaseID(scenario.getName()));

            Utils utils = new Utils();
            logger.info("Utils class - loadProperties() method - call start");
            utils.loadProperties();
            logger.info("Utils class - loadProperties() method - call completed");

            if(driver == null && firstTimeAppLaunch) {
                logger.info("DriverManager class - launchBrowser() method - call start");
                driver = DriverManager.launchBrowser();
                logger.info("Utils class - launchBrowser() method - call completed");
                driver.get(AllConstants.APP_URL.getValue());
                logger.info("Browser APP URL set");
                firstTimeAppLaunch = false;
            }

            ReadTestData readTestData = new ReadTestData();
            //testDataObj = readTestData.readAndSetTestDataInPOJO();
            AllConstants.TTFormTestData.setObjectValue(readTestData.readAndSetTestDataInPOJO());

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private String getTestcaseID(String scenarioName){
        return StringUtils.substringBetween(scenarioName,"[","]");
    }

}

package com.org.ttp.glue;

import com.org.ttp.utils.AllConstants;
import com.org.ttp.utils.ReadTestData;
import com.org.ttp.utils.Utils;
import com.org.ttp.utils.DriverManager;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class CommonStep {
    public static WebDriver driver;
    private static boolean firstTimeAppLaunch = true;
    public static final Logger logger = LogManager.getLogger(CommonStep.class);
    public static Scenario testcaseScenario;

    @Before
    public void beforeScenario(Scenario scenario){
        logger.info("Class:CommonStep--Method:beforeScenario()--started");
        try {
            testcaseScenario = scenario;
            AllConstants.TESTCASE_ID.setValue(getTestcaseID(scenario.getName()));

            Utils utils = new Utils();
            logger.info("Class:Utils--Method:loadProperties()--called");
            utils.loadProperties();
            logger.info("Class:Utils--Method:loadProperties()--call ended");

            if(driver == null && firstTimeAppLaunch) {
                logger.info("Class:DriverManager--Method:launchBrowser()--called");
                driver = DriverManager.launchBrowser();
                logger.info("Class:DriverManager--Method:launchBrowser()--call ended");
                driver.get(AllConstants.APP_URL.getValue());
                firstTimeAppLaunch = false;
            }

            ReadTestData readTestData = new ReadTestData();
            logger.info("Class:AllConstants.TTFormTestData--Method:setObjectValue()--called");
            AllConstants.TTFormTestData.setObjectValue(readTestData.readAndSetTestDataInPOJO());
            logger.info("Class:AllConstants.TTFormTestData--Method:setObjectValue()--call ended");
            logger.info("Class:CommonStep--Method:beforeScenario()--ended");
        }catch(Exception e){
            logger.error(e.getMessage());
        }
    }

    @AfterStep
    public void afterEachScenarioStep(Scenario scenario){
        try{
        byte[] screenshotByteArray = ((TakesScreenshot)DriverManager.getDriver() ).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshotByteArray,"image/png","");
        }catch(Exception e){
            logger.error(e.getMessage());
        }
    }

    public static String getTestcaseID(String scenarioName){
        return StringUtils.substringBetween(scenarioName,"[","]");
    }

}

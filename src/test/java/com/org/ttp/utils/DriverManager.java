package com.org.ttp.utils;

import com.org.ttp.glue.CommonStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {
    private static WebDriver driver = null;
    public static WebDriver getDriver() {
        return driver;
    }
    public static final Logger logger = LogManager.getLogger(DriverManager.class);
    public static WebDriver launchBrowser(){
        logger.info("Class:DriverManager--Method:launchBrowser()--called");
        try{
            switch(AllConstants.BROWSER.getValue()){
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }
        }catch(Exception e){
            logger.error(e.getMessage());
        }
        logger.info("Class:DriverManager--Method:launchBrowser()--ended");
        return driver;
    }
}

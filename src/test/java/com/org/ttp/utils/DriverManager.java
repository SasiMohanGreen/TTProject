package com.org.ttp.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {

    private static WebDriver driver = null;

    public static WebDriver launchBrowser(){
        try{
            switch(AllConstants.BROWSER.getValue()){
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return driver;
    }
}

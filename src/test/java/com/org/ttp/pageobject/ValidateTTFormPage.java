package com.org.ttp.pageobject;

import com.org.ttp.pojo.TTFormTestData;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class ValidateTTFormPage {

    private WebDriver driver;

     private final JavascriptExecutor jsExecutor;

     private final Actions actions;

     private Wait<WebDriver> fluentWait;
    private WebElement Male.c;

    public ValidateTTFormPage(WebDriver driver){
         this.driver = driver;
         this.jsExecutor = (JavascriptExecutor) driver;
         PageFactory.initElements(driver,this);
         actions = new Actions(driver);
         fluentWait = new FluentWait<>(driver)
                 .withTimeout(Duration.ofSeconds(30))
                 .pollingEvery(Duration.ofSeconds(2))
                 .ignoring(NoSuchElementException.class);
     }
    @FindBy(id="64532b5f00efba00121f117e")
     WebElement FirstName;

    @FindBy(id="64532b696a6af30013dc8321")
    WebElement LastName;

    @FindBy(id="6453521e35eb0c00128fa97d")
    WebElement Email;

    @FindBy(id="radio-11")
    WebElement Male;

    @FindBy(id="radio-12")
    WebElement Female;

    @FindBy(id="6453527335eb0c00128fbabf")
    WebElement MobileNum;

    @FindBy(id="645352c16dc31e001202f56f")
    WebElement DOB;

    @FindBy(xpath="//input[@aria-label='Sports']")
    WebElement Sports;

    @FindBy(xpath="//input[@aria-label='Music']")
    WebElement Music;

    @FindBy(xpath="//input[@aria-label='Reading']")
    WebElement Reading;

    @FindBy(className="chakra-button css-1szjd8b")
    WebElement SubmitBtn;

    @FindBy(className="chakra-text css-ah0vfz")
    WebElement SubmitSuccessMsg;

    @FindBy(className="chakra-button css-4my61l")
    WebElement SubmitAnotherResponseBtn;

    public void fillMandatoryField(TTFormTestData testData){
        FirstName.sendKeys(testData.getFirstname());
        LastName.sendKeys(testData.getLastName());
        Email.sendKeys(testData.getEmail());
        if(testData.getGender().equalsIgnoreCase("Male")){
            Male.click();
        }else if(testData.getGender().equalsIgnoreCase("Female")){
            Female.click();
        }
        MobileNum.sendKeys(testData.getMobileNum());
        DOB.sendKeys(testData.getDob());
        for(String hobby:testData.getHobbies()){
            switch(hobby){
                case "Sports":
                    Sports.click();
                    break;
                case "Music":
                    Music.click();
                    break;
                case "Reading":
                    Reading.click();
                    break;
            }
        }
        SubmitBtn.click();
    }

}

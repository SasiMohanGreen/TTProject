package com.org.ttp.pageobject;

import com.org.ttp.pojo.TTFormTestData;
import com.org.ttp.utils.AllConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.List;

public class ValidateTTFormPage {
    public WebDriver driver;
     private final Actions actions;
     private final Wait<WebDriver> fluentWait;
    public static final Logger logger = LogManager.getLogger(ValidateTTFormPage.class);
    public ValidateTTFormPage(WebDriver driver){
         this.driver = driver;
         PageFactory.initElements(driver,this);
         actions = new Actions(driver);
         fluentWait = new FluentWait<>(driver)
                 .withTimeout(Duration.ofSeconds(20))
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

    @FindBy(xpath="//input[@id='radio-11']/parent::label[@data-checked]")
    List<WebElement> Male_Checked;

    @FindBy(id="radio-12")
    WebElement Female;

    @FindBy(xpath="//input[@id='radio-12']/parent::label[@data-checked]")
    List<WebElement> Female_Checked;

    @FindBy(id="6453527335eb0c00128fbabf")
    WebElement MobileNum;

    @FindBy(id="645352c16dc31e001202f56f")
    WebElement DOB;

    @FindBy(xpath="//input[@aria-label='Sports']")
    WebElement Sports;

    @FindBy(xpath="//input[@aria-label='Sports']/parent::label[@data-checked]")
    List<WebElement> Sports_Checked;
    @FindBy(xpath="//input[@aria-label='Music']")
    WebElement Music;

    @FindBy(xpath="//input[@aria-label='Music']/parent::label[@data-checked]")
    List<WebElement> Music_Checked;
    @FindBy(xpath="//input[@aria-label='Reading']")
    WebElement Reading;

    @FindBy(xpath="//input[@aria-label='Reading']/parent::label[@data-checked]")
    List<WebElement> Reading_Checked;
    @FindBy(xpath="//a[@class='chakra-link css-17hnxff' and contains(text(),'Choose')]")
    WebElement ChooseFile;

    @FindBy(xpath="//span[text()='North']/ancestor::div[@data-index]")
    WebElement NorthLocation;

    @FindBy(xpath="//span[text()='South']/ancestor::div[@data-index]")
    WebElement SouthLocation;

    @FindBy(xpath="//span[text()='East']/ancestor::div[@data-index]")
    WebElement EastLocation;

    @FindBy(xpath="//span[text()='West']/ancestor::div[@data-index]")
    WebElement WestLocation;

    @FindBy(xpath="//span[text()='Central']/ancestor::div[@data-index]")
    WebElement CentralLocation;

    @FindBy(xpath="//textarea[@id='6453553781cb0e001299cc83']")
    WebElement Address;
    @FindBy(xpath="//button[@class='chakra-button css-1szjd8b']")
    WebElement SubmitBtn;

    @FindBy(xpath="//*[@class='chakra-text css-ah0vfz']")
    WebElement SubmitSuccessMsg;

    @FindBy(xpath="//div[@class='css-1ag8dug']")
    List<WebElement> MandatoryFieldErrorMsg;

    @FindBy(xpath="//*[@class='chakra-button css-4my61l']")
    List<WebElement> SubmitAnotherResponseBtn;

    public void fillForm(TTFormTestData testData, String uploadType) {
        logger.info("Class:ValidateTTFormPage--Method:fillForm()--started");
        try {
            setFirstName(testData.getFirstname());
            setLastName(testData.getLastName());
            setEmail(testData.getEmail());
            setGender(testData.getGender());
            setMobile(testData.getMobileNum());
            setDOB(testData.getDob());
            setHobbies(testData.getHobbies());
            chooseFileToUpload(uploadType);
            setLocation(testData.getLocation());
            setAddress(testData.getAddress());
            clickEmptySpace("Address");
            clickWEWithWait(SubmitBtn);
        }catch(Exception e){
            logger.error(e.getMessage());
        }
        logger.info("Class:ValidateTTFormPage--Method:fillForm()--ended");
    }

    private void chooseFileToUpload(String fileType) {
      try{
        StringSelection fileToUpload = null;
        String path =   AllConstants.TESTDATA_FILEPATH.getValue();
        path = StringUtils.replace(path,"/", File.separator);
        switch(fileType){
            case "TEXT":
                fileToUpload = new StringSelection(AllConstants.SYSTEM_PATH.getValue()+path+AllConstants.TEXT_FILENAME.getValue()+".txt");
                break;
            case "IMAGE":
                fileToUpload = new StringSelection(AllConstants.SYSTEM_PATH.getValue()+path+AllConstants.IMAGE_FILENAME.getValue()+".png");
                break;
        }
        if(fileType.equalsIgnoreCase("TEXT") || fileType.equalsIgnoreCase("IMAGE")) {
            ChooseFile.click();
            Thread.sleep(5000);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileToUpload, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            Thread.sleep(3000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(5000);
        }
        }catch(Exception e){
            logger.error(e.getMessage());
        }
    }

    private void clickEmptySpace(String weName){
       By emptySpaceXpath = By.xpath("//div[@class='css-9x4jlj' and contains(text(),'"+weName+"')]");
        WebElement emptySpaceWE = driver.findElement(emptySpaceXpath);
        fluentWait.until(ExpectedConditions.visibilityOf(emptySpaceWE));
        fluentWait.until(ExpectedConditions.elementToBeClickable(emptySpaceWE));
        actions.moveToElement(emptySpaceWE).click().build().perform();
    }

    private void clickWEWithWait(WebElement we){
        fluentWait.until(ExpectedConditions.elementToBeClickable(we));
        actions.moveToElement(we).click().build().perform();
    }

    private void setFirstName(String firstName){
        clickEmptySpace("First");
        customSendKeys(FirstName, firstName);
    }

    private void setLastName(String lastName){
        clickEmptySpace("Last");
        customSendKeys(LastName, lastName);
    }
    private void setEmail(String email){
        clickEmptySpace("Email");
        customSendKeys(Email, email);
    }
    private void setGender(String gender){
        clickEmptySpace("Gender");
        resetGender();
        if (gender.equalsIgnoreCase("Male")) {
            clickWEWithWait(Male);
        } else if (gender.equalsIgnoreCase("Female")) {
            clickWEWithWait(Female);
        }
    }
    private void setMobile(String mobile){
        clickEmptySpace("Mobile");
        customSendKeys(MobileNum, mobile);
    }
    private void setDOB(String dob){
        clickEmptySpace("Date");
        customSendKeys(DOB, dob);
    }
    private void setHobbies(String[] hobbies){
        clickEmptySpace("Hobbies");
        resetHobby();
        for (String hobby : hobbies) {
            switch (hobby) {
                case "Sports":
                    clickWEWithWait(Sports);
                    break;
                case "Music":
                    clickWEWithWait(Music);
                    break;
                case "Reading":
                    clickWEWithWait(Reading);
                    break;
            }
        }
    }
    private void setLocation(String location){
        clickEmptySpace("Location");
        switch (location) {
            case "East":
                clickWEWithWait(EastLocation);
                break;
            case "West":
                clickWEWithWait(WestLocation);
                break;
            case "South":
                clickWEWithWait(SouthLocation);
                break;
            case "North":
                clickWEWithWait(NorthLocation);
                break;
            case "Central":
                clickWEWithWait(CentralLocation);
                break;
        }
    }
    private void setAddress(String addr){
        clickEmptySpace("Address");
        clickWEWithWait(Address);
        customSendKeys(Address, addr);
    }
    private void resetGender(){
        if(!Male_Checked.isEmpty()){
                clickWEWithWait(Male);
        }else if(!Female_Checked.isEmpty()){
            clickWEWithWait(Female);
        }
    }

    private void resetHobby(){
        if(!Sports_Checked.isEmpty()){
            clickWEWithWait(Sports);
        }
        if(!Music_Checked.isEmpty()){
            clickWEWithWait(Music);
        }
        if(!Reading_Checked.isEmpty()){
            clickWEWithWait(Reading);
        }
    }

    private void customSendKeys(WebElement we,String testData){
        actions.moveToElement(we).click().build().perform();
        we.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        we.sendKeys(testData);
    }

    public boolean assertSuccessMsg(){
        fluentWait.until(ExpectedConditions.visibilityOf(SubmitSuccessMsg));
        return SubmitSuccessMsg.isDisplayed();
    }

    public int assertErrorMsg(int value,String flag){
        By errorMsgXpath= By.xpath("//div[@class='css-1ag8dug']");
        fluentWait.until(driver -> driver.findElements(errorMsgXpath).size()==value);
        int size = 0;
        for(WebElement we:MandatoryFieldErrorMsg) {
            if(we.isDisplayed() && flag.equalsIgnoreCase("MANDATORY")){
                ++size;
            }else if(we.isDisplayed() && we.getText().contains("valid") && flag.equalsIgnoreCase("VALID_INPUT")){
                ++size;
            }
        }
        return size;
    }

    public void clickSubmit(){
        SubmitBtn.click();
    }

    public void clickSubmitAnotherResponse(){
        if(!SubmitAnotherResponseBtn.isEmpty())
            SubmitAnotherResponseBtn.get(0).click();
    }

}

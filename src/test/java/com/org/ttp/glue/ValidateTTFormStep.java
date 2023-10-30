package com.org.ttp.glue;

import com.org.ttp.pageobject.ValidateTTFormPage;
import com.org.ttp.utils.AllConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;

public class ValidateTTFormStep {

    private final WebDriver driver = CommonStep.driver;
    public static final Logger logger = LogManager.getLogger(ValidateTTFormStep.class);
    private final ValidateTTFormPage validateTTFormPage = PageFactory.initElements(driver,ValidateTTFormPage.class);
    @Given("the user launches the form")
    public void launchApp(){
    }

    @When("the user fills in the mandatory details")
    public void enterMandatoryValues() {
        validateTTFormPage.clickSubmitAnotherResponse();
        logger.info("Class:ValidateTTFormStep--Method:enterMandatoryValues()--started");
        validateTTFormPage.fillForm(AllConstants.TTFormTestData.getObjectValue(),"");
        logger.info("Class:ValidateTTFormStep--Method:enterMandatoryValues()--ended");
    }

    @When("the user fills in all details")
    public void enterAllValues()  {
        validateTTFormPage.clickSubmitAnotherResponse();
        logger.info("Class:ValidateTTFormStep--Method:enterAllValues()--started");
        validateTTFormPage.fillForm(AllConstants.TTFormTestData.getObjectValue(),"");
        logger.info("Class:ValidateTTFormStep--Method:enterAllValues()--ended");
    }

    @When("the user fills the form with {string} and with all details")
    public void enterAllValuesWithUpload(String uploadType)  {
        validateTTFormPage.clickSubmitAnotherResponse();
        logger.info("Class:ValidateTTFormStep--Method:enterAllValues()--started");
        validateTTFormPage.fillForm(AllConstants.TTFormTestData.getObjectValue(),uploadType);
        logger.info("Class:ValidateTTFormStep--Method:enterAllValues()--ended");
    }

    @When("the user fills only given details and clicks submit button")
    public void enterOnlyGivenValues() {
        validateTTFormPage.clickSubmitAnotherResponse();
        logger.info("Class:ValidateTTFormStep--Method:enterOnlyGivenValues()--started");
        validateTTFormPage.fillForm(AllConstants.TTFormTestData.getObjectValue(),"");
        logger.info("Class:ValidateTTFormStep--Method:enterOnlyGivenValues()--ended");
    }

    @When("the user clicks submit button without filling mandatory fields")
    public void clickSubmit(){
        validateTTFormPage.clickSubmit();
    }

    @Then("the user asserts the form is submitted successfully")
    public void assertSubmit(){
        Assert.assertTrue("Submit Unsuccessful",validateTTFormPage.assertSuccessMsg());
    }
    @Then("the user asserts {int} mandatory fields error message is displayed")
    public void assertMandatoryFieldsErrorMsg(int value){
        Assert.assertEquals("Mandatory Error message not displayed as expected", value, validateTTFormPage.assertErrorMsg(value,"MANDATORY"));
    }

    @Then("the user asserts {int} invalid input error message is displayed")
    public void assertValidInputFieldsErrorMsg(int value){
        Assert.assertEquals("Mandatory Error message not displayed as expected", value, validateTTFormPage.assertErrorMsg(value,"VALID_INPUT"));
    }

    @When("the user fills the form with all details and with <upload_type>")
    public void theUserFillsTheFormWithAllDetailsAndWithUpload_type() {
    }
}

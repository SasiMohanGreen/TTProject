package com.org.ttp.glue;

import com.org.ttp.pageobject.ValidateTTFormPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;

public class ValidateTTFormStep {

    private WebDriver driver = CommonBeforeStep.driver;
    private ValidateTTFormPage validateTTFormPage = PageFactory.initElements(driver,ValidateTTFormPage.class);
    private static final Logger logger = LogManager.getLogger(ValidateTTFormStep.class);
    @Given("the user launches the form")
    public void launchApp(){

    }

    @When("the user fills in the mandatory details")
    public void enterMandatoryValues(){
        validateTTFormPage.fillMandatoryField(CommonBeforeStep.testDataObj);

    }

    @Then("the user asserts the form is submitted successfully")
    public void assertSubmit(){
        Assert.assertTrue();
    }

}

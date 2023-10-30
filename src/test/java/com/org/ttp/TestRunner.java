package com.org.ttp;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue = {"com.org.ttp.glue"},
        plugin = {"pretty","html:target/CucumberReports/report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@30Oct",
        dryRun = false,
        monochrome = true
)

public class TestRunner {

}

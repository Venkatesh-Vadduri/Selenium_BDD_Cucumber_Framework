package com.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)

@CucumberOptions(

        plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        glue={"com.stepDef","com.base"},

        features= "@target/failed_scenarios.txt",
        monochrome=true,
        tags = "@SmokeTest1"

)
public class FailedTestRunner {

}

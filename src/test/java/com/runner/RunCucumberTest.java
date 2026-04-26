package com.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)

@CucumberOptions(   plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                            "rerun:target/failed_scenarios.txt"},
                    glue={"com.stepDef","com.base"},

                    features= "features/Login.feature",
                    monochrome=true,
                    tags = "@SmokeTest1"

                )


public class RunCucumberTest {

}

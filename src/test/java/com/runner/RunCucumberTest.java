package com.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)

@CucumberOptions(   plugin={"pretty","html:target/CucumberReports/CucumberReport.html"}, glue={"com.stepDef","com.base"},
                    features= "features/Register.feature",
                    monochrome=true,
                    tags = "@SmokeTest1"

                )


public class RunCucumberTest {

}

package com.trycloud.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                  "html:target/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "com/trycloud/step_definitions",
        dryRun = true,
        tags = "@wip"
)
public class Runner {

}

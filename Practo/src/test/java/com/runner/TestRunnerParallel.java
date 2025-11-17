package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src/test/resources/com/feature", // Same feature path
    glue = "com.stepDefinitionTestNG",           // Same glue path
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",     // HTML report
        "json:target/cucumber.json",             // JSON report
        "junit:target/cucumber.xml"              // JUnit report
    },
    monochrome = true
)
public class TestRunnerParallel extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/feature",
    glue = {"com.stepDefinitionTestNG"},
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    tags = "@AddToCart",
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
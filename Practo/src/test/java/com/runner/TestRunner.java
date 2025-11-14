//package com.runner;
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//import org.testng.annotations.DataProvider;
//
//@CucumberOptions(
//        features = "src/test/resources/Features",
//        glue = {"com.stepDefinitionTestNG"},
//        plugin = {"pretty", "html:target/cucumber-report.html"},
//        monochrome = false
//)
//public class TestRunner extends AbstractTestNGCucumberTests {
//
//    @Override
//    @DataProvider(parallel = false)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
//}


package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"com.stepDefinitionTestNG"},
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = false
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
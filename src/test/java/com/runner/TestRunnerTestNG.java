package com.runner;


/*
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.parameters.ExcelReader;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = ".\\src\\test\\resources\\com\\features\\Login.feature",
//		features =	"src/test/resources/com/features/Login.feature",
    		   glue = {"com.stepDefinitionTestNG"},
//    		    tags="@valid,@overview",
    		   tags="@ExcelData",
    		    
//    plugin = {"pretty", "html:target/cucumber-reports.html"}
	plugin = {"pretty", "html:target/cucumber-reports.html",
			"pretty","html:reports/HTMLReports.html",
			"json:reports/json-report.json",
			"junit:reports/junit_report.xml"}
 

)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {


//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }

}

*/

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/com/features/Login.feature",   // ✅ Path to .feature files
        glue = {"com.stepDefinitionTestNG"},                           // ✅ Package where step defs exist
        plugin = {"pretty", "html:target/cucumber-report.html",
        		"pretty","html:reports/HTMLReports.html",
    			"json:reports/json-report.json",
    			"junit:reports/junit_report.xml"},
        monochrome = true
)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
}
	

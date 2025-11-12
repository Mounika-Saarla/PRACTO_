
package com.runner;
import java.util.List;
import org.testng.annotations.DataProvider;
import com.parameters.ExcelReader;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/feature",
    glue = {"com.stepDefinitionTestNG"},
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    tags = "@SearchTests",
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
//
//@CucumberOptions(
//	    features = "src/test/resources/features",
//	    glue = {"stepDefinitions"},
//	    plugin = {"pretty"}
//	)
//	public class TestRunner extends AbstractTestNGCucumberTests {
//
//	    @DataProvider
//	    public Object[][] scenarios() {
//	        String filePath = "src/test/resources/TestData.xlsx";
//	        Object[][] data = new Object[][] {
//	            { ExcelReader.getCellData(filePath, 0, 0, 0) },
//	            { ExcelReader.getCellData(filePath, 0, 1, 0) },
//	            { ExcelReader.getCellData(filePath, 0, 2, 0) }
//	        };
//	        return data;
//	    }
//	}

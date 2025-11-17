
package com.runner;
import java.util.List;
import org.testng.annotations.DataProvider;
import com.parameters.ExcelReader;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/com/feature",  // ✅ Correct path
	    glue = {"com.stepDefinitionTestNG"},
	    //tags ="@lipidProfilePage",
	 // tags="@NegativeScenario",
	    plugin = {"pretty", "html:target/cucumber-reports.html"  }
	)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
}


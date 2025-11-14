package com.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class TestRunnerParallel extends AbstractTestNGCucumberTests {

	
	@DataProvider(parallel=true)  // parallel run
	public Object[][] scenarios()
 
	{
 
		return super.scenarios();
 
	}

}

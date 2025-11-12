//
//package com.stepDefinitionTestNG;
//
//import com.setup.BaseSteps;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//
//public class Hooks {
//    @Before
//    public void setUp() {
//        BaseSteps.initDriver();
//    }
//
//    @After
//    public void tearDown() {
//        BaseSteps.quitDriver();
//    }
//}
package com.stepDefinitionTestNG;

import com.setup.BaseSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void setUp() {
        BaseSteps.initDriver();
    }

    @After
    public void tearDown() {
        BaseSteps.quitDriver();
    }
}
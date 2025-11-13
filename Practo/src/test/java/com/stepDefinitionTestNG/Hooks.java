package com.stepDefinitionTestNG;

import com.setup.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void setUp() {
        BaseSteps.initializeDriver();
    }

    @After
    public void tearDown() {
        BaseSteps.quitDriver();
    }
}
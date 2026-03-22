package com.chromatech.stepDefinitions;

import com.chromatech.WebDriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void setUp(){
        WebDriverUtils.initializeBrowser();
    }

    @After
    public void tearDown(){
        WebDriverUtils.tearDown();
    }
}

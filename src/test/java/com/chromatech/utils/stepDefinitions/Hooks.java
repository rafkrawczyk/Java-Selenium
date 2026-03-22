package com.chromatech.utils.stepDefinitions;

import com.chromatech.utils.WebDriverUtils;
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

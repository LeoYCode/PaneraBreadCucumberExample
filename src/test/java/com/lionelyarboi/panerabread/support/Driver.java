package com.lionelyarboi.panerabread.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {DriverFactory.class})
public class Driver {

    @Autowired
    public WebDriver webDriver;

    @Autowired
    public WebDriverWait webDriverWait;
}

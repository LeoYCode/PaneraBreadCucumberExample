package com.lionelyarboi.panerabread.support;

import com.lionelyarboi.panerabread.config.PropertiesContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.ContextConfiguration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ContextConfiguration(classes = {PropertiesContext.class})
public class DriverFactory {

    @Autowired
    private int deviceWidth;

    @Autowired
    private int deviceHeight;

    @Autowired
    private String deviceUserAgent;

    @Autowired
    private String browser;

    @Autowired
    private String activeProfile;

    @Bean(name = "webDriver", destroyMethod = "quit")
    public WebDriver webDriver() {
        WebDriver driver = null;
        switch(browser) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                if (activeProfile.equals("mobile")) {
                    Map<String, Object> deviceConfig = new HashMap<>();
                    Map<String, Object> mobileEmulation = new HashMap<>();
                    deviceConfig.put("width", deviceWidth);
                    deviceConfig.put("height", deviceHeight);
                    mobileEmulation.put("deviceMetrics", deviceConfig);
                    mobileEmulation.put("userAgent", deviceUserAgent);

                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setExperimentalOption("mobileEmulation",mobileEmulation);
                    driver = new ChromeDriver(chromeOptions);
                } else {
                    driver = new ChromeDriver();
                }
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                throw new IllegalArgumentException("Unexpected value: " + browser.toLowerCase());
        }
        return driver;
    }

    @Bean(name = "webDriverWait")
    public WebDriverWait webDriverWait() {
        WebDriverWait wait;
        wait = new WebDriverWait(webDriver(), 10);
        return wait;
    }
}

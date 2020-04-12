package com.lionelyarboi.panerabread.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class PropertiesContext {

    @Value("${selenium.web.browser}")
    private String seleniumWebBrowser;

    @Value("${mobile.width}")
    private int deviceWidth;

    @Value("${mobile.height}")
    private int deviceHeight;

    @Value("${mobile.user.agent}")
    private String deviceUserAgent;

    @Value("${spring.profiles.active:desktop}")
    private String activeProfile;

    @Bean("browser")
    public String getWebBrowser() {
        return seleniumWebBrowser;
    }

    @Bean("deviceWidth")
    public int getDeviceWidth() {
        return deviceWidth;
    }

    @Bean("deviceHeight")
    public int getDeviceHeight() {
        return deviceHeight;
    }

    @Bean("deviceUserAgent")
    public String getDeviceUserAgent() {
        return deviceUserAgent;
    }

    @Bean("activeProfile")
    public String getActiveProfile() {
        return activeProfile;
    }
}

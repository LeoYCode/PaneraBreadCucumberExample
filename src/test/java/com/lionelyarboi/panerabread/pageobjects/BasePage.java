package com.lionelyarboi.panerabread.pageobjects;

import org.springframework.stereotype.Component;

@Component
public abstract class BasePage extends BaseWaitPage {

    public void load(String url) {
        webDriver.get(url);
    }
}

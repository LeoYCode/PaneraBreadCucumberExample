package com.lionelyarboi.panerabread.pageobjects;

import com.lionelyarboi.panerabread.support.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

@Component
public class BaseWaitPage extends Driver {

    protected void waitForElementToAppear(By locator) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForElementToDisappear(By locator) {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForElementToBeClickable(By locator) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitForTextToDisappear(By locator, String text) {
        webDriverWait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
    }

}

package com.lionelyarboi.panerabread.pageobjects.desktop;

import com.lionelyarboi.panerabread.pageobjects.BasePage;
import com.lionelyarboi.panerabread.pageobjects.ISignInPage;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("desktop")
public class SignInPage extends BasePage implements ISignInPage {

    @Override
    public SignInPage clickForgotPasswordButton() {
        webDriver.findElement(By.xpath("//a[contains(text(),'Forgot email or password?')]")).click();
        return this;
    }

    @Override
    public SignInPage clickSendEmailButton() {
        String sendEmailButton = ".button-primary";
        waitForElementToAppear(By.cssSelector(sendEmailButton));
        webDriver.findElement(By.cssSelector(sendEmailButton)).click();
        return this;
    }

    @Override
    public SignInPage enterEmailAddress(String emailAddress) {
        String forgotPasswordTextField = "#forgot_password_email";
        waitForElementToBeClickable(By.cssSelector(forgotPasswordTextField));
        webDriver.findElement(By.cssSelector(forgotPasswordTextField)).sendKeys(emailAddress);
        return this;
    }

    @Override
    public String invalidEmailErrorText() {
        String emailErrorText = "span.error";
        waitForElementToAppear(By.cssSelector(emailErrorText));
        return webDriver.findElement(By.cssSelector(emailErrorText)).getText();
    }
}

package com.lionelyarboi.panerabread.pageobjects.desktop;

import com.lionelyarboi.panerabread.pageobjects.BasePage;
import com.lionelyarboi.panerabread.pageobjects.IHomePage;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Profile("desktop")
public class HomePage extends BasePage implements IHomePage {

    @Override
    public void load() {
        super.load("https://www.panerabread.com/en-us/home.html");
    }

    @Override
    public SignInPage clickSignIn() {
        String signIn = "#member.notLoggedInView";
        waitForElementToAppear(By.cssSelector(signIn));
        webDriver.findElement(By.cssSelector(signIn)).click();
        return new SignInPage();
    }
}

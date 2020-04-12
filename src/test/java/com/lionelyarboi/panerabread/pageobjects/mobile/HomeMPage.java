package com.lionelyarboi.panerabread.pageobjects.mobile;

import com.lionelyarboi.panerabread.pageobjects.BasePage;
import com.lionelyarboi.panerabread.pageobjects.IHomePage;
import com.lionelyarboi.panerabread.pageobjects.desktop.SignInPage;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("mobile")
public class HomeMPage extends BasePage implements IHomePage {

    @Override
    public void load() {
        super.load("https://www.panerabread.com/en-us/home.html");
    }

    public HomeMPage clickBurgerMenu() {
        webDriver.findElement(By.cssSelector("#menuOpenbtn")).click();
        return this;
    }

    @Override
    public SignInPage clickSignIn() {
        String globalSignIn = "#mobile-page-header #global-sign-in";
        clickBurgerMenu();
        waitForElementToBeClickable(By.cssSelector(globalSignIn));
        webDriver.findElement(By.cssSelector(globalSignIn)).click();
        return new SignInPage();
    }
}

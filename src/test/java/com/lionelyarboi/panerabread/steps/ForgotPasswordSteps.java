package com.lionelyarboi.panerabread.steps;

import com.lionelyarboi.panerabread.pageobjects.IHomePage;
import com.lionelyarboi.panerabread.pageobjects.ISignInPage;
import io.cucumber.java.Before;
import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class ForgotPasswordSteps implements En {

    @Autowired
    private IHomePage iHomePage;

    @Autowired
    private ISignInPage iSignInPage;

    @Before
    public void setUp() {
        iHomePage.load();
    }

    public ForgotPasswordSteps() {
        Given("I am on sign-in screen", () -> {
            iHomePage.clickSignIn();
        });

        When("^I click forgot password button$", () -> {
            iSignInPage.clickForgotPasswordButton();
        });

        And("^I enter invalid email address \"([^\"]*)\"$", (String invalidEmail) -> {
            iSignInPage.enterEmailAddress(invalidEmail);
            iSignInPage.clickSendEmailButton();
        });

        Then("^I should see \"([^\"]*)\" error message$", (String invalidEmailErrorMessage) -> {
            assertEquals(iSignInPage.invalidEmailErrorText(), invalidEmailErrorMessage);
        });
    }
}

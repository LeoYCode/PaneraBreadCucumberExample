package com.lionelyarboi.panerabread.pageobjects;

import com.lionelyarboi.panerabread.pageobjects.desktop.SignInPage;

public interface ISignInPage {
    SignInPage clickForgotPasswordButton();
    SignInPage enterEmailAddress(String emailAddress);
    String invalidEmailErrorText();
    SignInPage clickSendEmailButton();
}

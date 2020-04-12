Feature: Forgotten Password Email or Password

  Scenario: Identify your account incorrect email
    Given I am on sign-in screen
    And I click forgot password button
    When I enter invalid email address "123456"
    Then I should see "Please provide valid email" error message
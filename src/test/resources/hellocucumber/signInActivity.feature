Feature: Sign in form feature

  Scenario: This test checks whether the sign in form works properly or not
    Given user accesses the main page
    When user fills in login and password
    Then user logs in successfully
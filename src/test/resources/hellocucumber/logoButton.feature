Feature: Logo Button

  Scenario: This test checks whether the logo button redirects users back to home page from the contact page.
    Given user accesses the home page
    When user clicks on the contact button and back to the logo button
    Then user gets redirected to the contact page
Feature: Google test

  Scenario: This test checks whether the cart works properly or not
    Given Chrome browser is open
    When user goes to Google.co.in
    Then the webpage is loaded
    When user searches for something
    Then user can see how many results are displayed
    When user does not enter anything and clicks on search
    Then nothing should occur
    When user searched for something irrelevant (misspelled)
    Then there is a "Did you mean” link
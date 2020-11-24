Feature: Contact form feature

  Scenario: This test checks whether the contact form works properly or not
    Given user accesses the contact page
    When user fills in the data
    Then user's e-mail is sent
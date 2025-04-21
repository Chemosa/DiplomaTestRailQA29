Feature: Registration on testrail.com

  @smoke
  Scenario: Registration of the new user
    Given User wants to get trial version of access to testrail.com
    When User fill the registration form
    And Click submission button to create account
    Then Message about confirmation via email should appear an another page
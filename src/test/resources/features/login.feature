
Feature:User should be able to login

  Background:
    Given the user is on the login page

  Scenario: User should be able to login with valid credentials
    When user login with valid credentials
    Then user should be log in dashboard

  Scenario: User should not be able to login with invalid credentials
    When user login with invalid credentials
    Then user should see "Wrong username or password." warning message

  Scenario: Username input box should be case sensitive
    When user insert "UsEr1" as username and valid password
    Then user should see "Wrong username or password." warning message






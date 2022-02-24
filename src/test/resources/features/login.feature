
Feature:User should be able to login

  Background:
    Given the user is on the login page

  Scenario: User should be able to login with valid credentials
    When user login with valid credentials
    Then user should be log in dashboard
  @wip
  Scenario: User should not be able to login with invalid credentials
    When user login with invalid credentials
    Then user should see "Wrong username or password." warning message






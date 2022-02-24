@wip
Feature:User should be able to login

  Background:
    Given the user is on the login page

  Scenario: User should be able to login with valid credentials
    When user login with valid credentials
    Then user should be log in dashboard




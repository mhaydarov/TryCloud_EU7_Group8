@wip
Feature:User should be able to login

  Background:
    Given the user is on the login page

  Scenario: User should be able to login with valid credentials
    When user enters "username" into username input box
    And user enters "password" into password input box
    Then user should be log in dashboard


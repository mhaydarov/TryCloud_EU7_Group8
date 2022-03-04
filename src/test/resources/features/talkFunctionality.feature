
@Cloud-286
Feature: Create a new conversation in the Talk module

  Background:
    Given the user is on the login page
    When user login with valid credentials
    Then user should be log in dashboard

  Scenario: Basic user should be able to crate conversation in the Talk module
    When User Clicks on "Talk" button on the upper side of the page
    And User Click on + icon from the up left corner next toSearch converations or users input box
    And User Enter conversation name on the pop up box
    Then User Click on "Create" conversation button
    Then User Verify name the conversation is  displayed first on the conversations list

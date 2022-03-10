Feature: Calendar Display Functionality

  Background:
    Given the user is on the login page
    When user login with valid credentials
    Then user should be log in dashboard

  Scenario : User should be able to choose Daily-Weekly-Monthly  events from Calendar module

      When User Clicks on "Calendar" button on the upper side of the page
      And User Clicks on hamburger menu
      And a drop down options list  should appear
      Then drop down list  should have the following options
        | Day    |
        | Week   |
        | Month   |
        | List    |
      Scenario Outline:  User should be able to see Daily-Weekly-Monthly events

       When user clicks on the <period> button
       Then user verify if <period> events are displayed
        Examples:
       |period|
       |Day   |
       |Week  |
       |Month |



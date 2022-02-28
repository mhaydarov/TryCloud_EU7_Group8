
Feature: As a user, I should be able to change my online status and set a status message

  Background:
    Given the user is on the login page
    When user login with valid credentials
    Then user should be log in dashboard
  @wip
    Scenario: User should be able to reach Online Status module by clicking on recent status at the profile icon dropdown at Dashboard
      When user clicks on profile Icon at the right corner of Dashboard page
      Then user should see recent status is displayed under profile dropdown
Feature: As a user, I should be able to change my online status and set a status message

  Background:
    Given the user is on the login page
    When user login with valid credentials
    Then user should be log in dashboard
    When user clicks on profile Icon at the right corner of Dashboard page
    And user clicks on recent online status button


  Scenario: User should be able to reach Online Status module by clicking on recent status at the profile icon dropdown at Dashboard

    Then user should see recent status is displayed under profile dropdown


  Scenario: User should be able to see "Online Status" header at the module

    Then user shold see "Online Status" as header


  Scenario Outline: Online status options which are 'Online, Away, Do not disturb, Invisible' should be visible

    Then "<online options>" should be displayed
    Examples:

      | online options |
      | online         |
      | away           |
      | invisible      |
      | dnd            |

  Scenario: User should be able to see "Status Message" header at the module

    Then user should see "Status message" as header

  @wip
  Scenario: User can view status message input box and "What's your status?" message in it

    Then user should see "What's your status?" message in message input box

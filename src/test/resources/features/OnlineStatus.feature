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


  Scenario: User can view status message input box and "What's your status?" message in it

    Then user should see "What's your status?" message in message input box


  Scenario: User can type status message in the input box.

    Then Status Message input box should be interactable and user should be able to insert "Message" into it



  Scenario Outline: User can view default status message options in the same order as " In a meeting (bold and calendar icon beside it ) an hour(pale), Commuting(bold and bus icon beside it) - 30 minutes(pale), Working remotely(bold and building icon beside it)-Today(pale), Out sick(bold and sick emoji beside it) Today(pale), Vacationing(bold and tree emoji beside it)-Don't clear(pale)"

    Then user should see "<main message>" and "<side message>" near to it

    Examples:

    |main message|side message|
    |In a meeting|an hour|
    |Commuting|30 minutes|
    |Working remotely|Today|
    |Out sick|Today|
    |Vacationing|Don't clear|

  @wip
  Scenario: User can view the dropdown with the name "Clear status after" to select clear time range
    Then user should see clear selection dropdown near the  "Clear status after" name
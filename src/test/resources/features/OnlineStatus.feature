
Feature: As a user, I should be able to change my online status and set a status message

  Background:
    Given the user is on the login page
    When user login with valid credentials
    Then user should be log in dashboard
    When user clicks on profile Icon at the right corner of Dashboard page
    And user clicks on recent online status button

  @smoke
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

  @smoke
  Scenario: User can type status message in the input box.

    Then Status Message input box should be interactable and user should be able to insert "Message" into it


  Scenario Outline: User can view default status message options in the same order as " In a meeting (bold and calendar icon beside it ) an hour(pale), Commuting(bold and bus icon beside it) - 30 minutes(pale), Working remotely(bold and building icon beside it)-Today(pale), Out sick(bold and sick emoji beside it) Today(pale), Vacationing(bold and tree emoji beside it)-Don't clear(pale)"

    Then user should see "<main message>" and "<side message>" near to it

    Examples:

      | main message     | side message |
      | In a meeting     | an hour      |
      | Commuting        | 30 minutes   |
      | Working remotely | Today        |
      | Out sick         | Today        |
      | Vacationing      | Don't clear  |


  Scenario: User can view the dropdown with the name "Clear status after" to select clear time range
    Then user should see clear selection dropdown near the  "Clear status after" name


  Scenario: User can view the clear selection option after clicking dropdown at the same order as "Don't clear,30 minutes, 1 hour, 4 hours, Today, This week"
    When user clicks on Clear status after dropdown
    Then user should see following Clear status options
      | Don't clear |
      | 30 minutes  |
      | 1 hour      |
      | 4 hours     |
      | Today       |
      | This week   |

  @smoke
  Scenario: User can click every selection for clear time
    When user clicks on "Don't clear" option
    Then "Don't clear" should displayed on Clear status input box
    When user clicks on "30 minutes" option
    Then "30 minutes" should displayed on Clear status input box
    When user clicks on "4 hours" option
    Then "4 hours" should displayed on Clear status input box
    When user clicks on "Today" option
    Then "Today" should displayed on Clear status input box
    When user clicks on "This week" option
    Then "This week" should displayed on Clear status input box
    When user clicks on "1 hour" option
    Then "1 hour" should displayed on Clear status input box

  @smoke
  Scenario Outline: User can set every online status by clicking on them.

    When user clicks on "<online options>" online option
    Then "<online options>" should be displayed under profile icon dropdown

    Examples:
      | online options |
      | online         |
      | away           |
      | invisible      |
      | dnd            |

  @smoke
  Scenario: User can view and click "Set status message" button with the blue background to set status message

    When user should insert "Example Message" into status message input box
    And user should see and click on Set status message button
    Then user should see "Example Message" on dashboard


  @smoke
  Scenario: User can view  and click "Clear status message" button with the grey background to clear status message
    When user should insert "Example Message" into status message input box
    And user should see and click on Set status message button
    And user clicks on  Clear status message button
    Then user should see that previous "Example Message" is not displayed anymore






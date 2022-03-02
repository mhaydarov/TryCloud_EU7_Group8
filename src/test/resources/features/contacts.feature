@contacts
Feature:Contacts Functionality
  Scenario: User should be able to create a new contact

      Given the user is on the dashboard page
    When   user clicks on the Contacts module
    And  user clicks on the New contact option
    Then user creates a new contact

    Scenario: Deleting a contact
      Given The user is on the dashboard page
      When   user clicks on the Contacts module
      And    user clicks on a contact
      And    user clicks on Delete option
      Then   user deletes the selected contact


      Scenario: Editing a contact
        Given The user is on the dashboard page
        When   user clicks on the Contacts module
        And    user clicks on a contact
        Then   user edits the selected contact


Feature:
  As a basic user, I should be able to create a new conversation in the Talk module

  Scenario:
 When User  Hoover over "Talk" button from top functionalities bar
    And User Clicks on "Talk" button on the upper side of the page
    And User Click on + icon from the up left corner next toSearch converations or users input box
    And User Enter conversation name on the pop up box
    And User Selects user name from the "Add user" list
    Then User Click on "Create" conversation button
    Then User Verify name the conversation is  displayed first on the conversations list

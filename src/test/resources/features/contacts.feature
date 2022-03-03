
Feature:Contacts Functionality
	Background:

		Given the user is on the login page
		When user login with valid credentials
		And  the user is on the dashboard page
	@CLOUD-268
	Scenario: Creating new Contact
		Given  user clicks on the Contacts module  on Dashboard page
		    Then   new page opens with title Contacts
		    When   user clicks on the New contact button
		    Then   contact details section opens on the right 
		    And    user enters the contact details
		    Then   user creates a new contact
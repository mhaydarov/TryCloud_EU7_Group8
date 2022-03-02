Feature:User should be able to upload a file

  Background:
    Given the user is on the login page
    When user login with valid credentials
    Then user should be log in dashboard

  @TRY-240
  Scenario: Uploading files
    When User navigates to "files" module
    And User clicks + button and uploads file
    Then the file should appear in that folder after being uploaded
    Then the number of uploaded files should increase accordingly
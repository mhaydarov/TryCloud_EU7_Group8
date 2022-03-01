Feature:User should be able to upload a file

  Background:
    Given the user is on the login page
    When user login with valid credentials
    Then user should be log in dashboard

  @TRY-240
  Scenario: Uploading valid and invalid files
    Given User navigates to "files" module
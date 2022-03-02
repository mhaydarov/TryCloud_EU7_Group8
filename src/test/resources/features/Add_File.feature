Feature:User should be able to upload a file

  Background:
    Given the user is on the login page
    When user login with valid credentials
    Then user should be log in dashboard
    When User navigates to "files" module

  @TRY-240
  Scenario Outline: Uploading files into the root folder
    When User clicks + button and uploads "<file>"
    Then the file should appear in that folder after being uploaded
    Then the storage size should change accordingly

    Examples:
      | file                                        |
      | C:\\Users\\Merdan\\Desktop\\Test\\file1.txt |

  @TRY-240
  Scenario Outline: Creating a folder and uploading files into it
    When User clicks + button and creates a folder and navigates into it
    And User clicks + button and uploads "<file>"
    Then the file should appear in that folder after being uploaded
    Then the storage size should change accordingly

    Examples:
      | file                                        |
      | C:\\Users\\Merdan\\Desktop\\Test\\file1.txt |

  @TRY-240c
  Scenario: Creating a doc file
    When User clicks + button and creates a doc and navigates into it
    And User clicks + button and uploads "<file>"
    Then the file should appear in that folder after being uploaded
    Then the storage size should change accordingly


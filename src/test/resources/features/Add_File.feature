Feature:User should be able to upload a file

  Background:
    Given the user is on the login page
    When user login with valid credentials
    Then user should be log in dashboard
    When user navigates to "files" module
    Given the storage is empty


  Scenario: Uploading valid files into the root folder
    When user clicks + button and uploads a file
     | C:\\Users\\Merdan\\Desktop\\Test\\file1.txt |
    Then the file should appear in that folder after being uploaded
    Then the storage size should change accordingly


  Scenario: Uploading invalid files into the root folder
    When user clicks + button and uploads a file
      | C:\\Users\\Merdan\\Desktop\\Test\\file2.exe |
    Then user should should see "File type not allowed" warning message and the file should not upload


  Scenario: Uploading multiple files into the root folder
    When user clicks + button and uploads files
      | C:\\Users\\Merdan\\Desktop\\Test\\file1.txt |
      | C:\\Users\\Merdan\\Desktop\\Test\\file3.txt |
    Then user should should see "Uploading multiple files not allowed" warning message and the file should not upload


  Scenario: Creating a folder and uploading files into it
    When User clicks + button and creates a folder and navigates into it
    When user clicks + button and uploads a file
      | C:\\Users\\Merdan\\Desktop\\Test\\file1.txt |
    Then the file should appear in that folder after being uploaded
    Then the storage size should change accordingly


  Scenario: Creating a doc file
    When User clicks + button and creates a doc and navigates into it
    And User clicks + button and uploads "<file>"
    Then the file should appear in that folder after being uploaded
    Then the storage size should change accordingly


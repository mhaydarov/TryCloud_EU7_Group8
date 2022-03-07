@smoke
Feature:User should be able to upload a file

  Background:
    Given the user is on the login page
    When user login with valid credentials
    Then user should be log in dashboard
    When user navigates to "files" module
    Given the storage is empty

  @CLOUD-298
  Scenario: Uploading valid files into the root folder
    When user clicks + button and uploads a file
      | C:\\Users\\Merdan\\Desktop\\Test\\test123_file1.txt |
    Then the file should appear in that folder after being uploaded
    Then the storage size should change accordingly

  @CLOUD-299
  Scenario: Uploading invalid files into the root folder
    When user clicks + button and uploads a file
      | C:\\Users\\Merdan\\Desktop\\Test\\test123_file2.exe |
    Then user should should see "File type not allowed" warning message and the file should not upload

  @CLOUD-300
  Scenario: Uploading multiple files into the root folder
    When user clicks + button and uploads files
      | C:\\Users\\Merdan\\Desktop\\Test\\test123_file1.txt |
      | C:\\Users\\Merdan\\Desktop\\Test\\test123_file3.txt |
    Then user should should see "Uploading multiple files not allowed" warning message and the file should not upload

  @CLOUD-301
  Scenario: Creating a folder with valid name and uploading files into it
    When user clicks + button and creates a folder and opens it
      | char limit | 20 |
    When user clicks + button and uploads a file
      | C:\\Users\\Merdan\\Desktop\\Test\\test123_file1.txt |
    Then the file should appear in that folder after being uploaded
    Then the storage size should change accordingly

  @CLOUD-302
  Scenario: Creating a folder with invalid name and uploading files into it
    When user clicks + button and creates a folder and opens it
      | char limit | 21 |
    Then user should should see "File name exceeds the char limit" warning message and the file should not upload

  @CLOUD-303
  Scenario: Creating folders with duplicate names (case sensitive) or empty name
    When user clicks + button and tries to create "test1" and "test1" folders
    Then user should should see "test1 already exists" warning message
    When user clicks + button and tries to create "test2" and "Test2" folders
    Then user should see both folders on the screen
    When user clicks + button and tries to create folder with empty name
    Then user should should see "File name cannot be empty." warning message

  @CLOUD-304
  Scenario: Creating a default doc file
    When user clicks + button and creates a default doc file ("New text document.md")
    Then user should see the new doc file opened

  @CLOUD-306
  Scenario: Creating a doc file
    When user clicks + button and creates a doc file
      | char limit | 20 |
    Then user should see the new doc file opened

  @CLOUD-307
  Scenario: Creating docs with duplicate names (case sensitive) or empty name
    When user clicks + button and tries to create "test1.md" and "test1.md" doc files
    Then user should should see "test1.md already exists" warning message
    When user clicks + button and tries to create "test2.md" and "Test2.md" doc files
    Then user should see both doc files on the screen
    When user clicks + button and tries to create doc file with empty name
    Then user should should see "File name cannot be empty." warning message

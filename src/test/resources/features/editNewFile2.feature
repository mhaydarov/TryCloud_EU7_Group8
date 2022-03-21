@new
Feature: User should be able to add nw file

  Background:
    Given the user is on the home page

    Scenario: User should be click add file
      When user clicks the folder button right top of the dashboard page
      And user clicks the plus sign at the all files page
      And select the upload file button
      Then verify the upload successfully achieved

      Scenario: User should be move or copy a file or folder
        When user clicks the three dots of the selected folder or file
        And select the "Move or Copy" option
        And select the "New test Folder" option
        And select the "Copy to New test folder" option
        Then verify copying process done successfully

        Scenario: User should delete any file or folder
          When user clicks the three dots of the selected folder or file
          And select the "Delete file" option
          Then verify the that the file deleted




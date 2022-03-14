@tag
Feature: User should be able to see data under Settings Page

  Background:
    Given the user is on the home page

@CLOUD-296
Scenario: User should be able to reach Personnel Settings Page
    When User click the name on the right top
    And click on the Settings button
    Then User should see the tıtle as "Settings"

@CLOUD-297
Scenario: User should be able to change the data on name and email boxes
  When User enter "Dakato D." to the full name box
  And User hit the enter key
  And User enter "dakato@yahoo.com" to the email box
  And User hit the enter key
  Then User should see this new data displayed on the boxes

@CLOUD-309
  Scenario: User should be able to change the data on the phone number box

    When User enters wrong data "okul oku!" to the phone box
    And User hit the enter key
    Then User should not see this wrong data accepted
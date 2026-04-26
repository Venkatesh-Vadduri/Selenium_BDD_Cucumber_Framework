Feature: Login functionality

  @SmokeTest1
  Scenario Outline: Login with valid credentials
    Given User navigates to login page
    When User enters <Email> and <Password>
    And User clicks on Login button
    Examples:
      | Email                     | Password |
      | ramuvadduri@gmail.com     | Test@123 |
      | rajeshvadduri@gmail.com   | Test@123 |

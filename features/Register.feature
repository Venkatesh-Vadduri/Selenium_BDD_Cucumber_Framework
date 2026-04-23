Feature: Login functionality

  @SmokeTest
  Scenario: Create Account only with Mandatory Fields
    Given User navigates to Registration page
    When User enters details into below fields
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should get created successfully

  @SmokeTest1
  Scenario: Create Account only with All Fields
    Given User navigates to Registration page
    When User enters details into below fields
    And User selects Newsletter
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should get created successfully
Feature: Register functionality

  @TC_RF_01
  Scenario: Verify Registering an Account by providing only the Mandatory fields
    Given User navigates to Registration page
    When User enters details into below fields
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should get created successfully

  @TC_RF_02
  Scenario: Verify Registering an Account by providing all the fields
    Given User navigates to Registration page
    When User enters details into below fields using Data Table
      |firstName	|Venkatesh						|
      |lastName		|Vadduri						|
      |telephone	|1234567890						|
      |password		|Test@123						|
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should get created successfully

  @TC_RF_03
  Scenario: Verify proper Notification Messages are Displayed
    Given User navigates to Registration page
    When User do not enters details into below fields
    And User clicks on Continue button
    Then User should get proper warning messages for every mandatory field

  @TC_RF_04
  Scenario: Verify Registering an Account when 'Yes' option is selected for Newsletter field
    Given User navigates to Registration page
    When User enters details into below fields
    And User selects Newsletter
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should get created successfully
    Then User click Continue button on Account Success page
    And User click on Subscribe unsubscribe Newsletter
    Then User should should See Newsletter subscribe Yes Option

  @TC_RF_05
  Scenario: Verify Registering an Account when 'No' option is selected for Newsletter field
    Given User navigates to Registration page
    When User enters details into below fields
    And User selects Newsletter
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should get created successfully
    Then User click Continue button on Account Success page
    And User click on Subscribe unsubscribe Newsletter
    Then User should should See Newsletter subscribe NO Option

  @TC_RF_06
  Scenario: Verify different ways of navigating to 'Register Account' page
    Given User click on My Account Dropdown in the Home page
    And User click on Register Option in the Home page
    And User click on My Account Dropdown in the Home page
    And User click on Login Option in the Home page
    When User clicks on Continue Button on New Customer page
    And User click on My Account Dropdown in the Home page
    And User click on Login Option in the Home page
    Then User click on Register Option
    Then User Able to See Register Account page



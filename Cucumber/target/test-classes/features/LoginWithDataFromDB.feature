 @DBFeature
 Feature: Techfios bank and cash New Account Functionality

Background:
  Given User is on the techfios login page


  @DBScenario1 @New
  Scenario Outline: User should be able to login with valid credentials
    and open a new account

   
    When User enters the "username" from mysql database
    When User enters the "password" from mysql database
    And User clicks on "login"
    Then User should land on Dashboard page
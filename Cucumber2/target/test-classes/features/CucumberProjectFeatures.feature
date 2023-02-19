@Regression
Feature: CucumberProjectFeature

  Background: 
    Given I am On Techfios practical Exam page

  @SetBlueBackground @Smoke
  Scenario: Sky Blue Background
    Given "Set SkyBlue Background" button exists
    When I clicked on the "Set_SkyBlue_Background_Button"
    Then The background color will change to "sky blue"

  @SetWhiteBackground
  Scenario: Sky White Background
    Given "Set White Background" button exists
    When I clicked on the "Set_White_Backgroung_Button"
    Then The background color will change to "white"
    
@EndToEndFlow
Feature: Validate End to end flow

  @regression @sanity
  Scenario: Validate end to end flow to place the order success
  	Given I launch the application
    When I add "Cucumber" and "3"
    And I click on cart icon
    And I click proceed to check out button
		Then I verify user is on place order page
		When I click on Place Order button
		Then I verify user is on address details page
		When I Select country and Accept the terms and conditions
		|Country|
		|India|
		And I click on Proceed button
		Then I validate the success message is displayed
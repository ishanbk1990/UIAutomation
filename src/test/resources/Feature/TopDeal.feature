@TopDeal
Feature: Validate End to end flow

  @regression @sanity
  Scenario: Verify the serach functionality working fine in Top deal
  	Given I launch the application
  	And I Navigate to Top deal Page
  	When I Search for the text 'apple'
  	Then I verify that only Items with word containing 'apple' is shown to user
  	

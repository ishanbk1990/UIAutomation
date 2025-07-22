@AddTocart
Feature: Validate add to cart functionality

  @regression
  Scenario Outline: Validate item successfully added to the cart
    Given I launch the application
    When I add "<Item>" and "<Quantity>"
    And I click on cart icon
    Then I verify the "<Item>" with "<Quantity>"  added to the cart

    Examples: 
      | Item        | Quantity |
      | Cauliflower |        2 |
      | Tomato      |        1 |

	@regression @checkout
	Scenario: Validate Proceed to checkout button functionality
	Given I launch the application
	When I click on cart icon
	Then I verify that proceed to checkout button is disabled
	When I click on cart icon
	And I add "Cauliflower" and "1"
	Then I verify that proceed to checkout button is enabled
	
	@ScenarioContext @regression @priceCheck
	Scenario: Validate the price on checkout page
	Given I launch the application
	When  I add "Cauliflower" and "1"
	And I get the "Cauliflower" price
	And I click on cart icon
  And I click proceed to check out button
  Then I verify the price of item
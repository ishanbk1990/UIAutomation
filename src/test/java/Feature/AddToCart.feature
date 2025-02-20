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
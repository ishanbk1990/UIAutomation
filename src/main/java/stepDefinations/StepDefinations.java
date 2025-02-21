package stepDefinations;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageClasses.CartPopUpPage;
import pageClasses.HomePage;
import resources.Utils;

public class StepDefinations extends Base{
	
	HomePage hp = new HomePage();
	CartPopUpPage cp = new CartPopUpPage();
	//static WebDriver driver;
	
	@Given("I launch the application")
	public void i_launch_the_application() {
		getDriver().get(Utils.getGlobalValue("baseUrl"));
	}

	@When("I add {string} and {string}")
	public void i_add_and(String itemName, String quantity) {
		List<WebElement> listOfItemNames = hp.getListOfItemNames(getDriver());
		for (int i = 0; i < listOfItemNames.size(); i++) {
			if(listOfItemNames.get(i).getText().contains(itemName)) {
				List<WebElement> listOfAddToCartButton = hp.getAddToCartButton(getDriver());
				List<WebElement> listOfQuantityInputBox = hp.getQuantityInputBox(getDriver());
				listOfQuantityInputBox.get(i).clear();
				listOfQuantityInputBox.get(i).sendKeys(quantity);
				listOfAddToCartButton.get(i).click();
				break;
			}
		}
	}
	
	@When("I click on cart icon")
	public void i_click_on_cart_icon() {
		hp.getCartIcon(getDriver()).click();
	}
	
	@Then("I verify the {string} with {string}  added to the cart")
	public void i_verify_the_with_added_to_the_cart(String itemName, String quantity) {
		System.out.println(cp.getProductName(getDriver()).getText());
		System.out.println(cp.getProductQuantity(getDriver()).getText());
		Assert.assertTrue(cp.getProductName(getDriver()).getText().contains(itemName));
		Assert.assertTrue(cp.getProductQuantity(getDriver()).getText().contains(quantity));
	}
	
	@Then("I verify that proceed to checkout button is disabled")
	public void i_verify_that_proceed_to_checkout_button_is_disabled() {
		String value = cp.getProceedToCheckoutButton(getDriver()).getDomAttribute("class");
		System.out.println(value);
		Assert.assertEquals("disabled", value);
	}
	
	@Then("I verify that proceed to checkout button is enabled")
	public void i_verify_that_proceed_to_checkout_button_is_enabled() {
		String value = cp.getProceedToCheckoutButton(getDriver()).getDomAttribute("class");
		System.out.println(value);
		Assert.assertEquals(" ", value);
	}
}

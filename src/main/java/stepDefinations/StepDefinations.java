package stepDefinations;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageClasses.AddressPage;
import pageClasses.CartPopUpPage;
import pageClasses.CheckOutPage;
import pageClasses.HomePage;
import resources.Utils;

public class StepDefinations extends Base{
	
	HomePage hp = new HomePage();
	CartPopUpPage cp = new CartPopUpPage();
	CheckOutPage co = new CheckOutPage();
	AddressPage ap = new AddressPage();
	
	@Given("I launch the application")
	public void i_launch_the_application() {
		getDriver().get(Utils.getGlobalValue("baseUrl"));
		getLogger().info("Application launched");
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
	
	@When("I click proceed to check out button")
	public void i_click_proceed_to_check_out_button() {
		cp.getProceedToCheckoutButton(getDriver()).click();
	}
	
	@Then("I verify user is on place order page")
	public void i_verify_user_is_on_place_order_page() {
		Assert.assertTrue(Utils.elementIsVisibleAndClickable(co.getPlaceOrderButtonLocator(), getDriver()));
	}

	@When("I click on Place Order button")
	public void i_click_on_place_order_button() {
		co.getPlaceOrderButton(getDriver()).click();
	}
	
	@Then("I verify user is on address details page")
	public void i_verify_user_is_on_address_details_page() {
		Assert.assertTrue(Utils.elementIsVisible(ap.getChooseCountryTextLocator(), getDriver()));
	}
	
	@When("I select I Select country and Accept the terms and conditions")
	public void i_select_i_select_and_accept_the_terms_and_conditions(DataTable dataTable) {
		 List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			String country = row.get("Country");
			Utils.selectByVisibleText(ap.getSelectDropDown(getDriver()), country);
		}
		ap.getTnCCheckbox(getDriver()).click();
	}
	
	@When("I click on Proceed button")
	public void i_click_on_proceed_button() {
		ap.getProceedButon(getDriver()).click();;
	}
	
	@Then("I validate the success message is displayed")
	public void i_validate_the_success_message_is_displayed() {
		ap.getSuccessMessage(getDriver());
	}
}

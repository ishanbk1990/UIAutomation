package stepDefinations;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageClasses.AddressPage;
import pageClasses.CartPopUpPage;
import pageClasses.CheckOutPage;
import pageClasses.HomePage;
import pageClasses.TopDeal;
import resources.DriverManager;
import resources.ScenarioContext;
import resources.TestContext;
import resources.Utils;

public class StepDefinations{
	
	private static final Logger logger = LogManager.getLogger(StepDefinations.class);
	private final WebDriver driver;
	private final TestContext context;
    private final HomePage hp;
    private final CartPopUpPage cp;
    private final CheckOutPage co;
    private final AddressPage ap;
    private final TopDeal tp;
    private final ScenarioContext scenarioContext;
    
    public StepDefinations(TestContext context) {
    	this.context = context;
    	scenarioContext = context.getScenarioContext();
    	this.driver = DriverManager.getDriver();
    	hp = context.getHomePage();
    	cp= context.getCartPopUpPage();
    	co = context.getCheckOutPage();
    	ap = context.getAddressPage();
    	tp = context.getTopDealPage();
    }
	
	@Given("I launch the application")
	public void i_launch_the_application() {
		driver.get(Utils.getGlobalValue("baseUrl"));
		logger.info("Application launched");
	}

	@When("I add {string} and {string}")
	public void i_add_and(String itemName, String quantity) {
		List<WebElement> listOfItemNames = hp.getListOfItemNames();
		for (int i = 0; i < listOfItemNames.size(); i++) {
			if(listOfItemNames.get(i).getText().contains(itemName)) {
				List<WebElement> listOfAddToCartButton = hp.getAddToCartButton();
				List<WebElement> listOfQuantityInputBox = hp.getQuantityInputBox();
				listOfQuantityInputBox.get(i).clear();
				listOfQuantityInputBox.get(i).sendKeys(quantity);
				listOfAddToCartButton.get(i).click();
				break;
			}
		}
	}
	
	@When("I click on cart icon")
	public void i_click_on_cart_icon() {
		hp.getCartIcon().click();
	}
	
	@Then("I verify the {string} with {string}  added to the cart")
	public void i_verify_the_with_added_to_the_cart(String itemName, String quantity) {
		System.out.println(cp.getProductName().getText());
		System.out.println(cp.getProductQuantity().getText());
		Assert.assertTrue(cp.getProductName().getText().contains(itemName));
		Assert.assertTrue(cp.getProductQuantity().getText().contains(quantity));
	}
	
	@Then("I verify that proceed to checkout button is disabled")
	public void i_verify_that_proceed_to_checkout_button_is_disabled() {
		String value = cp.getProceedToCheckoutButton().getDomAttribute("class");
		System.out.println(value);
		Assert.assertEquals("disabled", value);
	}
	
	@Then("I verify that proceed to checkout button is enabled")
	public void i_verify_that_proceed_to_checkout_button_is_enabled() {
		String value = cp.getProceedToCheckoutButton().getDomAttribute("class");
		System.out.println(value);
		Assert.assertEquals(" ", value);
	}
	
	@When("I click proceed to check out button")
	public void i_click_proceed_to_check_out_button() {
		cp.getProceedToCheckoutButton().click();
	}
	
	@Then("I verify user is on place order page")
	public void i_verify_user_is_on_place_order_page() {
		Assert.assertTrue(Utils.elementIsVisibleAndClickable(co.getPlaceOrderButtonLocator(), driver));
	}

	@When("I click on Place Order button")
	public void i_click_on_place_order_button() {
		co.getPlaceOrderButton().click();
	}
	
	@Then("I verify user is on address details page")
	public void i_verify_user_is_on_address_details_page() {
		Assert.assertTrue(Utils.elementIsVisible(ap.getChooseCountryTextLocator(), driver));
	}
	
	@When("I Select country and Accept the terms and conditions")
	public void i_select_i_select_and_accept_the_terms_and_conditions(DataTable dataTable) {
		 List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : data) {
			String country = row.get("Country");
			Utils.selectByVisibleText(ap.getSelectDropDown(), country);
		}
		ap.getTnCCheckbox().click();
	}
	
	@When("I click on Proceed button")
	public void i_click_on_proceed_button() {
		ap.getProceedButon().click();;
	}
	
	@Then("I validate the success message is displayed")
	public void i_validate_the_success_message_is_displayed() {
		ap.getSuccessMessage();
		System.out.println(ap.getSuccessMessage().getText());
	}
	
	@When("I get the {string} price")
	public void i_get_the_price(String itemName) {
		List<WebElement> listOfItemNames = hp.getListOfItemNames();
		for(int i=0;i<listOfItemNames.size();i++) {
			if(listOfItemNames.get(i).getText().contains(itemName)) {
				List<WebElement> listOfProductPrice= hp.getProductPrice();
				String price = listOfProductPrice.get(i).getText();
				scenarioContext.setContext("expectedPrice", price);
			}
		}
	}
	@Then("I verify the price of item")
	public void i_verify_the_price_of_item() {
	    String actualPrice = co.getItemPrice().getText();
	    Assert.assertEquals(scenarioContext.getContext("expectedPrice"), actualPrice);
	}
	
	@Given("I Navigate to Top deal Page")
	public void i_navigate_to_top_deal_page() {
	    hp.getTopDealLink().click();
	    Set<String> windowHandles = driver.getWindowHandles();
	    Utils.switchToWindowWithWebElement(driver,tp.getSearchBoxLocator(),windowHandles);
	}
}

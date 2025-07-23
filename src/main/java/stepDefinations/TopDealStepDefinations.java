package stepDefinations;

import java.util.List;

import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageClasses.TopDeal;
import resources.TestContext;

public class TopDealStepDefinations {

	private final TestContext contex;
	private final TopDeal tp;
	
	public TopDealStepDefinations(TestContext contex) {
		this.contex = contex;
		this.tp = contex.getTopDealPage();
	}
	@When("I Search for the text {string}")
	public void i_search_for_the_text(String value) {
	    tp.getSearchBox().click();
	    tp.getSearchBox().sendKeys(value);
	}
	@Then("I verify that only Items with word containing {string} is shown to user")
	public void i_verify_that_only_items_with_word_containing_is_shown_to_user(String expectedvalue) {
	    List<String> listOfItemName = tp.getListOfItemName();
	    SoftAssert sf = new SoftAssert();
	    for (String itemName : listOfItemName) {
			sf.assertTrue(itemName.toLowerCase().contains(expectedvalue));
		}
	    sf.assertAll();
	}
}

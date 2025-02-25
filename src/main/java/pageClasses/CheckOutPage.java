package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage {
	private By placeOrderButton = By.xpath("//button[text()='Place Order']");

	public WebElement getPlaceOrderButton(WebDriver driver) {
		return driver.findElement(placeOrderButton);
	}
	
	public By getPlaceOrderButtonLocator() {
		return placeOrderButton;
	}
}
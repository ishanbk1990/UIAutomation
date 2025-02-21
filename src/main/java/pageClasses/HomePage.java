package pageClasses;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private By itemName = By.xpath("//h4[@class='product-name']");
	private By addToCartButton = By.xpath("//button[text()='ADD TO CART']");
	private By quantityInputBox = By.xpath("//input[@class='quantity']");
	private By cartIcon = By.xpath("//a[@class='cart-icon']");

	public List<WebElement> getListOfItemNames(WebDriver driver) {
		return driver.findElements(itemName);
	}
	
	public List<WebElement> getAddToCartButton(WebDriver driver) {
		return driver.findElements(addToCartButton);
	} 
	
	public List<WebElement> getQuantityInputBox(WebDriver driver) {
		return driver.findElements(quantityInputBox);
	}
	
	public WebElement getCartIcon(WebDriver driver) {
		return driver.findElement(cartIcon);
	}
}

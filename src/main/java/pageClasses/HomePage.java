package pageClasses;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;
	private By itemName = By.xpath("//h4[@class='product-name']");
	private By addToCartButton = By.xpath("//button[text()='ADD TO CART']");
	private By quantityInputBox = By.xpath("//input[@class='quantity']");
	private By cartIcon = By.xpath("//a[@class='cart-icon']");
	private By topDealsLink = By.xpath("//a[text()='Top Deals']");
	private By productPrice = By.xpath("//div[@class='product']/p[@class='product-price']");
	
	public HomePage(WebDriver driver) {
	        this.driver = driver;
	 }

	public List<WebElement> getListOfItemNames() {
		return driver.findElements(itemName);
	}
	
	public List<WebElement> getAddToCartButton() {
		return driver.findElements(addToCartButton);
	} 
	
	public List<WebElement> getQuantityInputBox() {
		return driver.findElements(quantityInputBox);
	}
	
	public WebElement getCartIcon() {
		return driver.findElement(cartIcon);
	}
	
	public WebElement getTopDealLink() {
		return driver.findElement(topDealsLink);
	}
	
	public List<WebElement> getProductPrice() {
		return driver.findElements(productPrice);
	}
}

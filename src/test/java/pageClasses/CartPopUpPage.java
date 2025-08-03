package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPopUpPage {
	
	private WebDriver driver;
	private By productName = By.xpath("//li[@class='cart-item']/div[@class='product-info']/p[@class='product-name']");
	private By productQuantity = By.xpath("//li[@class='cart-item']/div[@class='product-total']/p[@class='quantity']");
	private By proceedToCheckoutButton = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	
	public CartPopUpPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getProductName() {
		return driver.findElement(productName);
	}
	
	public WebElement getProductQuantity() {
		return driver.findElement(productQuantity);
	}
	
	public WebElement getProceedToCheckoutButton() {
		return driver.findElement(proceedToCheckoutButton);
	}
}
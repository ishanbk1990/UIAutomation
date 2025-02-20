package pojo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPopUpPage {
	private By productName = By.xpath("//li[@class='cart-item']/div[@class='product-info']/p[@class='product-name']");
	private By productQuantity = By.xpath("//li[@class='cart-item']/div[@class='product-total']/p[@class='quantity']");
	private By proceedToCheckoutButton = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	
	public WebElement getProductName(WebDriver driver) {
		return driver.findElement(productName);
	}
	
	public WebElement getProductQuantity(WebDriver driver) {
		return driver.findElement(productQuantity);
	}
	
	public WebElement getProceedToCheckoutButton(WebDriver driver) {
		return driver.findElement(proceedToCheckoutButton);
	}
}
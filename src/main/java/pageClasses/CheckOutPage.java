package pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage {
	
	private WebDriver driver;
	private By placeOrderButton = By.xpath("//button[text()='Place Order']");	
	private By checkOutTableHeaders = By.xpath("//table[@id='productCartTables']/thead/tr/td");
	private By itemPrice = By.xpath("(//table[@id='productCartTables']/tbody/tr/td/p[@class='amount'])[1]");
	
	public CheckOutPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public List<WebElement> getCheckOutTableHeaders(){
		return driver.findElements(checkOutTableHeaders);
	}
	
	public WebElement getPlaceOrderButton() {
		return driver.findElement(placeOrderButton);
	}
	
	public By getPlaceOrderButtonLocator() {
		return placeOrderButton;
	}
	
	public WebElement getItemPrice() {
		return driver.findElement(itemPrice);
	}
}
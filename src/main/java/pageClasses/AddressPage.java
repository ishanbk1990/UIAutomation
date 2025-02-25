package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressPage {
	private By chooseCountryText = By.xpath("//label[text()='Choose Country']");
	private By proceedButton = By.xpath("//button[text()='Proceed']");
	private By selectDropDown = By.xpath("//select");
	private By tncCheckbox = By.xpath("//input[@type='checkbox']");
	private By successMessage = By.xpath("//div[contains(text(),'Thank you. Your order has been placed successfully ...!!! ')]");

	public By getChooseCountryTextLocator() {
		return chooseCountryText;
	}
	
	public WebElement getProceedButon(WebDriver driver) {
		return driver.findElement(proceedButton);
	}
	
	public WebElement getSelectDropDown(WebDriver driver) {
		return driver.findElement(selectDropDown);
	}
	
	public WebElement getTnCCheckbox(WebDriver driver) {
		return driver.findElement(tncCheckbox);
	}
	
	public WebElement getSuccessMessage(WebDriver driver) {
		return driver.findElement(successMessage);
	}
}

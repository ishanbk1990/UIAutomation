package pageClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopDeal {

	private WebDriver driver;
	private By deliveryDateLabel = By.xpath("//label[text()='Delivery Date']");
	private By searchBox = By.id("search-field");
	private By listOfItemName = By.xpath("//table[@class='table table-bordered']/tbody/tr/td[1]");
	
	public WebElement getDeliveryDateLabel() {
		return driver.findElement(deliveryDateLabel);
	}

	public TopDeal(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getSearchBox() {
		return driver.findElement(searchBox);
	}
	
	public By getSearchBoxLocator() {
		return searchBox;
	}
	
	public List<String> getListOfItemName(){
		List<String> listOfItemNames = new ArrayList<String>();
		List<WebElement> listOfWebElement = driver.findElements(listOfItemName);
		for (WebElement webElement : listOfWebElement) {
			listOfItemNames.add(webElement.getText());
		}
		return listOfItemNames;
	}
}

package resources;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import pageClasses.AddressPage;
import pageClasses.CartPopUpPage;
import pageClasses.CheckOutPage;
import pageClasses.HomePage;
import pageClasses.TopDeal;

public class TestContext {

	private HomePage hp;
	private CartPopUpPage cp;
	private CheckOutPage co;
	private AddressPage ap;
	private TopDeal tp;
	private ScenarioContext scenarioContext;
	
	public TestContext() {
		scenarioContext = new ScenarioContext();
	}
	
	public void initialiseDriver() {
		String browser = System.getProperty("browser");
		if(browser==null) {
			browser = Utils.getGlobalValue("browser");
		}
		System.out.println(browser);
		switch (browser) {
		case "edge":
			DriverManager.setDriver(new EdgeDriver());
			break;
		case "chrome":
			DriverManager.setDriver(new ChromeDriver());
			break;
		default:
			DriverManager.setDriver(new ChromeDriver());
		}
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}

    public HomePage getHomePage() {
        if (hp == null) {
            hp = new HomePage(DriverManager.getDriver());
        }
        return hp;
    }

    public CartPopUpPage getCartPopUpPage() {
        if (cp == null) {
            cp = new CartPopUpPage(DriverManager.getDriver());
        }
        return cp;
    }

    public CheckOutPage getCheckOutPage() {
        if (co == null) {
            co = new CheckOutPage(DriverManager.getDriver());
        }
        return co;
    }

    public AddressPage getAddressPage() {
        if (ap == null) {
            ap = new AddressPage(DriverManager.getDriver());
        }
        return ap;
    }
    
    public TopDeal getTopDealPage() {
    	if(tp == null) {
    		tp = new TopDeal(DriverManager.getDriver());
    	}
    	return tp;
    }
    
    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}

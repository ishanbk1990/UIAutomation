package stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Base{
	
	@Before
	public void setUp() {
		setupLogger();
		initialiseDriver();
	}
	
	@After
	public void tearDown() {
		closeDriver();
	}

}

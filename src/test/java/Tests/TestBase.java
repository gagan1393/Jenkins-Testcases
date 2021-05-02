package Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
	
	@BeforeTest
	public void setup()
	{
		System.out.println("The Browser opened is Chrome" );
	}
	
	@AfterTest
	public void teardown()
	{
		System.out.println("The Browser closed" );
	}

}

package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;



public class JenkinsTest {
	
	WebDriver driver = null;
	
	@Parameters({"Browser"})
	@BeforeTest
	public void setup(String BrowserName)
	{
		System.out.println("The Browser running is " + BrowserName);
			if(BrowserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if(BrowserName.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			else if(BrowserName.equalsIgnoreCase("ff")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
		
	}

	
	@Test(priority = 1)
	public void verify_ohm_title()
	{

		String title = driver.getTitle();
		System.out.println("The Page title is "+ title);
		Assert.assertEquals(title, "OrangeHRM");

	}
	
	@Test(priority = 2)
	public void verify_ohm_Logo()
	{
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='divLogo']//img")).isDisplayed());
		

	}
	
	@Test(priority = 3)
	public void verify_ohm_login_header()
	{
		String Logo_Header = driver.findElement(By.xpath("//div[@id='logInPanelHeading']")).getText();
		System.out.println("The Logo Header is "+ Logo_Header);
		Assert.assertEquals(Logo_Header, "LOGIN Panel");
	}

}

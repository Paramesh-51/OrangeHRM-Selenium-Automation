package TestNGAnnotation;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Annotations {
	
	WebDriver driver;
	//@BeforeTest
	@BeforeMethod
	public void BrowserLaunch()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void SwagLogIn_ValidInValid() throws InterruptedException
	{
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");

		driver.findElement(By.id("password")).sendKeys("paramesh");
	
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=2)
	public void SwagLogIn_InValidValid() throws InterruptedException
	{
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.id("user-name")).sendKeys("paramesh");
		//Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
	}
	
	
	  //@AfterTest
	 //@AfterMethod
	//@AfterClass
   @AfterSuite
	public void BrowserClose()
	{
	
	//driver.close();
		  driver.quit();
	}

}



package TestNGAnnotation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
	WebDriver driver;
	public void BrowserLaunch()
	{
		
	}

 
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

	@BeforeTest
	public void beforeTest()
	{
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.saucedemo.com/");
	}

	@Test
	public void Login1()
	{
		driver.findElement(By.id("user-name")).sendKeys("paramesh");

		driver.findElement(By.id("password")).sendKeys("secret_sauce");

		driver.findElement(By.id("login-button")).click();
	}
	
	@Test
	public void Login2()
	{
		driver.findElement(By.id("user-name")).sendKeys("standard_user");

		driver.findElement(By.id("password")).sendKeys("rathod");

		driver.findElement(By.id("login-button")).click();
	}

	@AfterTest
	public void BrowserClose()
	{
		driver.close();
	}

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}

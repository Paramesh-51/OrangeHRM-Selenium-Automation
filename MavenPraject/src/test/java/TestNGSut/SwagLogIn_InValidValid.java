package TestNGSut;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SwagLogIn_InValidValid {
	WebDriver driver;
	@Test(priority=1)
	public void CBrowserLaunch()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(priority=2)
	public void BSwagLogin() throws InterruptedException
	{
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("paramesh");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(2000);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority=3)
	public void ABrowserClose()
	{
	
	driver.close();
	}

}

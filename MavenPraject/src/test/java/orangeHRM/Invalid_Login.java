package orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Invalid_Login {

		public static void main(String[] args) throws InterruptedException {
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
			Thread.sleep(2000);
			
			driver.findElement(By.name("username")).sendKeys("Admin");
			Thread.sleep(2000);

			driver.findElement(By.name("password")).sendKeys("admin1234"); //password invalid
			Thread.sleep(2000);

			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(2000);
			
			

			
			driver.quit();
			

		}

	}



package orangeHRM;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchUser {

	public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();


        // Open OrangeHRM
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
       
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

        
        // Username
        WebElement username = wait1.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));username.sendKeys("Admin");

        // Password
        WebElement password = wait1.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));password.sendKeys("admin123");

        // Login button
        wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();

       // Click Admin menu
        wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Admin']"))).click();
        
       //Username
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement username1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
          By.xpath("//div[contains(@class,'oxd-table-filter')]//input[contains(@class,'oxd-input')]")));
          username1.sendKeys("Paramesh120");
          
          WebElement searchBtn = driver.findElement(By.xpath("//button[@type='submit']"));searchBtn.click();
     
	}

}

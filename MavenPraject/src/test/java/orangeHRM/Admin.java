
package orangeHRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Admin {

    public static void main(String[] args) throws InterruptedException {

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

        // Click Add button
        WebElement addButton = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add']")));addButton.click();

        // Click User Role dropdown
        wait1.until(ExpectedConditions.elementToBeClickable( By.xpath("(//div[contains(@class,'oxd-select-text')])[1]"))).click();

        // Select ESS
        wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'oxd-select-option')]//span[normalize-space()='ESS']"))).click();

     // EMPLOYEE NAME
        WebElement employeeName = wait1.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//label[normalize-space()='Employee Name']/following::input[@placeholder='Type for hints...'][1]")));

        Actions actions = new Actions(driver);
        
        actions.click(employeeName)
        .sendKeys("s")
        .pause(Duration.ofSeconds(2))
        .sendKeys(Keys.ARROW_DOWN)
        .sendKeys(Keys.ARROW_DOWN)
        .sendKeys(Keys.ENTER)
        .perform();
         
         // Click Status dropdown
        wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space()='Status']/following::div[contains(@class,'oxd-select-text')][1]"))).click();

        /*// Select Enabled
        wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'oxd-select-option')]//span[normalize-space()='Enabled']"))).click();*/

     // Select Enabled
        WebElement Disabled = wait1.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[contains(@class,'oxd-select-option')]//span[normalize-space()='Disabled']")));

        actions.click(Disabled).perform();

        // USERNAME
        WebElement newUsername = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='Username']/following::input[1]")));
        newUsername.sendKeys("Paramesh12345");
        
        // PASSWORD
         WebElement newPassword = wait1.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='Password']/following::input[1]")));
                newPassword.sendKeys("Admin@123");
                
        // Confirm Password
        WebElement confirmPassword = wait1.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='Confirm Password']/following::input[1]")));
                confirmPassword.sendKeys("Admin@123");
               
      // SAVE
     wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Save']"))).click();
       
        //System.out.println("User created successfully!");

        //driver.quit();
    }
}


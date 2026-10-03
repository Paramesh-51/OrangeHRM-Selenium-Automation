package orangeHRM_Testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrangeHRM_ValidLoginTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void validLogin() {

        // Browser setup
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open application
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        
    }
        @Test
         public void validLogin2() {
        // Enter Username
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("username"))).sendKeys("Admin");

        // Enter Password
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("password"))).sendKeys("admin123");

        // Click Login
        wait.until(ExpectedConditions.elementToBeClickable(
               
        		By.xpath("//button[contains(@class,'orangehrm-login-button')]"))).click();
        
         }
        @AfterMethod
         public void validLogin1() {
        // Close browser
        driver.quit();
    }
}
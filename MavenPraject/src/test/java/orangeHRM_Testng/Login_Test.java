package orangeHRM_Testng;

import org.testng.Assert;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Login_Test {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	 driver.get("https://opensource-demo.orangehrmlive.com/");
	 
	 //Implicit Wait Syntax //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     //Explicit Wait Syntax //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));

     System.out.println("Browser opened");
     
	}
	
	//VALID LOGIN
	
	@Test(priority = 1)
	public void valid_Login() {

	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']"))).sendKeys("Admin");

	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']"))).sendKeys("admin123");

	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();

	    // Wait until Dashboard page loads
	    wait.until(ExpectedConditions.urlContains("/dashboard"));
	    
	    String title = wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//h6[normalize-space()='Dashboard']"))).getText();
	   
	    Assert.assertEquals(title, "Dashboard");
	     
	     System.out.println(" 1- Valid Login Test Passed");
	}
	
	//INVALID LOGIN
	
	@Test(priority = 2)
	public void Invalid_Login() {

	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Adminp");

	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("admin123");

	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();

	    WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class,'oxd-alert-content-text')]")));

	    	String errorMessage = error.getText().trim();

	        System.out.println("Actual Message: " + errorMessage);

	        Assert.assertEquals(errorMessage, "Invalid credentials");

	    	System.out.println("2 - Invalid Login Test Passed");
	}
 
	// ADD USER
	
	@Test(priority = 3)
	public void AddUser() {
		
	
        // Username 
        WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));username.sendKeys("Admin");

        // Password
        WebElement password = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));password.sendKeys("admin123");

        // Login button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();

        
        // Verify Dashboard loaded
        wait.until(ExpectedConditions.urlContains("/dashboard"));

       // Click Admin menu
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Admin']"))).click();

        // Click Add button
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add']")));addButton.click();

        // Click User Role 
        wait.until(ExpectedConditions.elementToBeClickable( By.xpath("(//div[contains(@class,'oxd-select-text')])[1]"))).click();

        // Select ESS
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'oxd-select-option')]//span[normalize-space()='ESS']"))).click();

        // EMPLOYEE NAME
        WebElement employeeName = wait.until(
        ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space()='Employee Name']/following::input[@placeholder='Type for hints...'][1]")));

        employeeName.sendKeys("a");
       
        WebElement employeeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option']//span")));
        employeeOption.click();

         
        // Click Status dropdown
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space()='Status']/following::div[contains(@class,'oxd-select-text')][1]"))).click();

        // Select Enabled
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'oxd-select-option')]//span[normalize-space()='Enabled']"))).click();

        // Select Disabled
     
        /* WebElement Disabled = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'oxd-select-option')]//span[normalize-space()='Disabled']")));

        actions.click(Disabled).perform();*/

       // USERNAME
        WebElement newUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='Username']/following::input[1]")));
        
         newUsername.sendKeys("ppppppp");
        
        // PASSWORD
         WebElement newPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='Password']/following::input[1]")));
         newPassword.sendKeys("Admin@123");
                
        //Confirm Password
         WebElement confirmPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='Confirm Password']/following::input[1]")));
         confirmPassword.sendKeys("Admin@123");
               
        //SAVE
           wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Save']"))).click();

          System.out.println(" 3- Admin Add User Test Passed");
          
	}
	@Test(priority = 4)
	public void SystemUsers() {

	    // Login Username
	    WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
	    username.sendKeys("Admin");

	    // Login Password
	    WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
	    password.sendKeys("admin123");

	    // Login
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();

	    wait.until(ExpectedConditions.urlContains("/dashboard"));
	    System.out.println("Login Successful");

	    // Admin
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'viewAdminModule')]"))).click();

	    wait.until(ExpectedConditions.urlContains("/admin"));
	    System.out.println("Admin Page Opened");

	    // Search 
	    WebElement searchUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(
	    By.xpath("//label[normalize-space()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input")));
	    searchUsername.sendKeys("ppppppp");

        // Search Button
	    WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit' and contains(.,'Search')]")));
	    searchBtn.click();

	    System.out.println("User Searched Successfully");

	    // Edit 
	    WebElement editBtn = wait.until(ExpectedConditions.elementToBeClickable(
	    By.xpath("//div[@role='row'][.//div[contains(.,'ppppppp')]]" + "//button[.//i[contains(@class,'bi-pencil-fill')]]")));
	    editBtn.click();

	    // Wait for loader
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'oxd-form-loader')]")));

	    // Username field
	    WebElement editUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(
	    By.xpath("//label[normalize-space()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input")));

	    wait.until(driver ->"ppppppp".equals(editUsername.getAttribute("value")));

	    System.out.println("Before Edit: " + editUsername.getAttribute("value"));

	    // Clear old username
	    editUsername.click();
	    editUsername.sendKeys(Keys.CONTROL, "a");
	    editUsername.sendKeys(Keys.BACK_SPACE);

	    // Enter new username
	    editUsername.sendKeys("rrrrrrr");

	    System.out.println("After Edit: " + editUsername.getAttribute("value"));

	    // Save
	    WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit' and contains(.,'Save')]")));
	        
	    saveBtn.click();

	    // Wait for System Users page
	    wait.until(ExpectedConditions.urlContains("viewSystemUsers"));

	    System.out.println("User Updated Successfully");

	    // Search updated username rrrrrrr
	    WebElement searchUpdatedUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(
	    By.xpath("//label[normalize-space()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input")));
	     
	    searchUpdatedUsername.click();
	    searchUpdatedUsername.sendKeys(Keys.CONTROL, "a");
	    searchUpdatedUsername.sendKeys(Keys.BACK_SPACE);
	    searchUpdatedUsername.sendKeys("rrrrrrr");

	    // Search
	    WebElement searchAgain = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit' and contains(.,'Search')]")));
	   
	    searchAgain.click();

	    System.out.println("Searched Updated User: rrrrrrr");

	    // Delete rrrrrrr
	    WebElement deleteBtn = wait.until(
	    ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='row'][.//div[contains(.,'rrrrrrr')]]" + "//button[.//i[contains(@class,'bi-trash')]]")));
	    deleteBtn.click();

	    // Yes, Delete
	    WebElement confirmDelete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'oxd-button--label-danger')]")));
	    confirmDelete.click();

	    System.out.println("User Deleted Successfully");
	}
	
	@AfterMethod
	    public void tearDown() {
		  if (driver != null)
	        driver.quit();
		  System.out.println("Browser closed");
	    }
}



/*package orangeHRM_Testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login_Test {

    WebDriver driver;
    WebDriverWait wait;


    // =========================
    // BEFORE EACH TEST
    // =========================

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        System.out.println("Browser opened");
    }


    // =========================
    // COMMON LOGIN METHOD
    // =========================

    public void login() {

        // Username
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']"))).sendKeys("Admin");
        
        // Password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']"))).sendKeys("admin123");
       
        // Login Button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();

        // Wait for Dashboard
        wait.until( ExpectedConditions.urlContains("/dashboard"));
    }

    // =========================
    // VALID LOGIN
    // =========================

    @Test(priority = 1)
    public void valid_Login() {

        login();

        String title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[normalize-space()='Dashboard']"))).getText();

        Assert.assertEquals(title, "Dashboard");

        System.out.println("1 - Valid Login Test Passed");
    }


    // =========================
    // INVALID LOGIN
    // =========================

    @Test(priority = 2)
    public void Invalid_Login() {

        // Invalid Username
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Adminp");

        // Password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("admin123");

        // Login
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();

        // Error Message
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class,'oxd-alert-content-text')]")));

        String errorMessage = error.getText().trim();

        System.out.println("Actual Message: " + errorMessage);

        Assert.assertEquals(errorMessage, "Invalid credentials");

        System.out.println("2 - Invalid Login Test Passed");
    }


    // =========================
    // ADD USER
    // =========================

    @Test(priority = 3)
    public void AddUser() {

        login();


        // Admin Menu
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'viewAdminModule')]"))).click();

        // Add Button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add']"))).click();

        // User Role Dropdown
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,'oxd-select-text')])[1]"))).click();

        // Select ESS
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'oxd-select-option')]//span[normalize-space()='ESS']"))).click();

        // Employee Name
        WebElement employeeName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Type for hints...']")));
        employeeName.sendKeys("a");

        // Select Employee
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option']//span"))).click();

        // Status Dropdown
        wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//label[normalize-space()='Status']/following::div[contains(@class,'oxd-select-text')][1]"))).click();

        // Enabled
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'oxd-select-option')]//span[normalize-space()='Enabled']"))).click();


        // New Username
        WebElement newUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='Username']/following::input[1]")));
        newUsername.sendKeys("paramesh");


        // Password
        WebElement newPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='Password']/following::input[1]")));
        newPassword.sendKeys("Admin@123");


        // Confirm Password
        WebElement confirmPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='Confirm Password']/following::input[1]")));
        confirmPassword.sendKeys("Admin@123");

        // Save
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Save']"))).click();

        System.out.println("3 - Add User Test Passed");
    }


    // =========================
    // SEARCH + EDIT + DELETE
    // =========================

    @Test(priority = 4)
    public void SystemUsers() {

        login();


        // Admin Menu
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'viewAdminModule')]"))).click();

        wait.until(ExpectedConditions.urlContains("/admin"));

        // =====================
        // SEARCH USER
        // =====================

        WebElement searchUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//label[normalize-space()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input")));
        searchUsername.sendKeys("paramesh");

        // Search Button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit' and contains(.,'Search')]"))).click();
        System.out.println("User Searched Successfully");


        // =====================
        // EDIT USER
        // =====================
        

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='row'][.//div[contains(.,'paramesh')]]" + 
        "//button[.//i[contains(@class,'bi-pencil-fill')]]"))).click();

        // Wait for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'oxd-form-loader')]")));


        // Username Field
        WebElement editUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//label[normalize-space()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input")));


        // Wait until old username appears
        wait.until(driver -> "paramesh".equals(editUsername.getAttribute("value")));

        System.out.println("Before Edit: " + editUsername.getAttribute("value"));

        // Clear Old Username
        clearField(editUsername);

        // New Username
        editUsername.sendKeys("rathod");

        System.out.println("After Edit: " + editUsername.getAttribute("value"));

        // Save
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit' and contains(.,'Save')]"))).click();

        // Wait for System Users Page
      //  wait.until(ExpectedConditions.urlContains("viewSystemUsers"));

        // =====================
        // SEARCH UPDATED USER
        // =====================
     // Edit Save ayyaka
        System.out.println("User Updated Successfully");

        // System Users page ki return
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");

        // Updated user search
        WebElement username = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")));

        username.clear();
        username.sendKeys("rathod");

        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Search']")));

        searchBtn.click();

        System.out.println("Searched Updated User: rathod");
        // =====================
        // DELETE USER
        // =====================

     // rathod row lo Delete icon
     WebElement deleteIcon = wait.until(ExpectedConditions.elementToBeClickable(
    		 By.xpath("(//button[.//i[contains(@class,'bi-trash')]])[1]")));
     deleteIcon.click();

     // Yes, Delete confirmation
     WebElement confirmDelete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Yes, Delete']")));
      
     confirmDelete.click();

     System.out.println("User Deleted Successfully");

    }
    // =========================
    // COMMON CLEAR METHOD
    // =========================

    public void clearField(WebElement element) {

        element.click();

        element.sendKeys(Keys.CONTROL, "a");

        element.sendKeys(Keys.BACK_SPACE);
    }


    // =========================
    // AFTER EACH TEST
    // =========================

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            //driver.quit();
        }

        System.out.println("Browser closed");
    }
}
*/







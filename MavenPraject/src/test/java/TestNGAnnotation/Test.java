package TestNGAnnotation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
 
public class Test {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(3000);
		
		    driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.saucedemo.com/");
			Thread.sleep(3000);
			//driver.close();
			driver.quit();
			
		
	}

}




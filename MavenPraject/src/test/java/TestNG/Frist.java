package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frist {

    public static void main(String[] args) throws InterruptedException {
    	WebDriver driver = new ChromeDriver();

    	driver.get("https://www.google.com");

    	Thread.sleep(3000);

    	String title = driver.getTitle();

    	System.out.println(title);
    	System.out.println(title.length());
    	System.out.println(title.contains("Google"));
    	System.out.println(title.toUpperCase());

    	driver.quit();
    }
}

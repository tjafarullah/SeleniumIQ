package dropDown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingDropDown {
	
	static WebDriver driver;
	
public static void main(String[] args) throws Exception {
		
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		
		// Create an object of a Select class and pass the dropdown element that we identified as an argument
		
		WebElement dropdown = driver.findElement(By.name("country"));
		Select sel = new Select(dropdown);
		
		// Using Index
		sel.selectByIndex(3);
		
		Thread.sleep(3000);
		
		// Using Visible Text
		sel.selectByVisibleText("ARUBA");
		
		Thread.sleep(3000);
		
		// Using Value
		sel.selectByValue("ANTARCTICA");
		
		Thread.sleep(3000);
		
		driver.close();
		
		
	}

}

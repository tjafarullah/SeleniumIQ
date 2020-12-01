package syncronization;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait2 {
		
		static WebDriver driver;
        
		@Test
		public void explicitwait() throws Exception
		{
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.zamzar.com/");
			driver.manage().window().maximize();
			fileupload("C:\\Convert.txt");
			Select fileUploadOption=new Select(driver.findElement(By.id("convert-format")));
			fileUploadOption.selectByVisibleText("pdf");
			driver.findElement(By.xpath("//button[@id='convert-button']")).click();
			
			WebDriverWait wait=new WebDriverWait(driver,45);
			boolean result=wait.until(ExpectedConditions.titleIs("Zamzar - File conversion progress"));
			System.out.println("Title is visible :" +result);
			Thread.sleep(3000);
			driver.close();
			
		}
		
		
		public static void fileupload(String filePath) throws AWTException, InterruptedException  
		{
			
			driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
			StringSelection clipBoardPath = new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(clipBoardPath, null);
			
			Thread.sleep(5000);
			
			//Robot Class
			Robot robot = new Robot();
			
			//Keyboard Action : CTRL+V
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			
			//Keyboard Action : Enter
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_ENTER);
			
				
			 
		}


		

	}



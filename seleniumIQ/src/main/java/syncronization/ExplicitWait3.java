package syncronization;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait3 {

	static WebDriver driver;

	public static void main(String[] args) throws AWTException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.zamzar.com/");
		driver.manage().window().maximize();
		fileupload("C:\\JarFilr.jar"); //need jar file
		
		
		WebDriverWait wait=new WebDriverWait(driver,45);
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
	    String alertMsg = alert.getText();
	    System.out.println("Alert Message :" +alertMsg);
	    alert.dismiss();
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

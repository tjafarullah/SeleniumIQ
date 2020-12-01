package xpathExamples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathAxes {
	
	@Test
	public void rowValue()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://money.rediff.com/losers/bse/daily/groupa?src=gain_lose");
		
		int rowNum = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr")).size();
		System.out.println("Number of rows :" +rowNum);
		
		int colNum = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td")).size();
		System.out.println("Number of columns :" +colNum);
		
		
		WebElement RowData = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[3]"));
		String rowtext=RowData.getText();
		System.out.println("The row text of the web table : " +rowtext);
		
		WebElement ColData = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[3]/td[4]"));
		String coltext=ColData.getText();
		System.out.println("The col text of the web table : " +coltext);
		
		WebElement ColData1 = driver.findElement(By.xpath("//a[contains(text(),'Amber Enterprises')]/ancestor::tr"));
		String coltext1=ColData1.getText();
		System.out.println("The col1 text of the web table : " +coltext1);
		
		
		
		
				
		List<WebElement> companyList = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
		List<WebElement> groupList = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[2]"));
		List<WebElement> preCloseList = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[3]"));
		List<WebElement> currentPriceList = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));
		List<WebElement> changeList = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[5]"));
		
		for(int i=0;i<10;i++)
		{
			String company=companyList.get(i).getText().trim();
			String group=groupList.get(i).getText().trim();
			String preclose=preCloseList.get(i).getText().trim();
			String currentprice=currentPriceList.get(i).getText().trim();
			String change=changeList.get(i).getText().trim();
			System.out.println("Company :" +company+" | "+"Group :" +group+" | "+"Preclose :" +preclose+" | "+"Current Price :" +currentprice+" | "+"Change :" +change );
			
		}
		
		driver.close();
		
	}
	
	

}

package IQ;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortingTable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/howto/howto_js_sort_table.asp");
		
		/*
		 * String s1 = "JAVA";
           String s2 = "SELENIUM";
           String s3 ="JAVA";

           s1.compareTo(s2) -  less than 0 -1
           s2.compareTo(s1) - greater than 0 +1
           s1.compareTo(s3) -  == 0

		 */
		
		driver.findElement(By.xpath("//button[contains(text(),'Sort')]")).click();
		List<WebElement> tdList = driver.findElements(By.xpath("//table[@id='myTable']/tbody/tr/td[1]"));
		String strArray[]=new String[tdList.size()];
		for(int i=0;i<tdList.size();i++)
		{
			strArray[i]=tdList.get(i).getText();
		}
		
		/*
		 *  Compare the String
		 */
		boolean sortFunctionality=true;
		outer:
			for(int i=0;i<strArray.length;i++)
			{
				for(int j=i+1;j<strArray.length;j++)
				{
					int result=strArray[j].compareTo(strArray[i]);
					if(!(result>0))
					{
						System.out.println("Data in the Table is not sorted :" +strArray[j]+ "::"+ strArray[i]);
						sortFunctionality=false;
						break outer;
					}
					else
					{
						System.out.println("Data in the table is sorted :" +strArray[j]+ "::"+ strArray[i]);
					}
				}
			}
		
		if(sortFunctionality)
		{
			System.out.println("Sort Functionality is working");
		}
		else
		{
			System.out.println("Sort Functionality is not working");
		}
		

	}

}

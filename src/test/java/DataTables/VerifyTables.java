package DataTables;

import org.testng.annotations.Test;

import AutomationFramework.Browser;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertTrue;

import java.util.List;

import javax.swing.Scrollable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;

public class VerifyTables extends Browser {

		
	@FindBy (xpath ="//table[@class='display dataTable']/tbody/tr")
	List<WebElement> WebtableRows;
	@FindBy (xpath ="//table[@class='display dataTable']/tbody/tr/td")
	List<WebElement> Webtablecols;

	@Test	
	public void verifyWebTable() throws Throwable
	{
		PageFactory.initElements(driver, this);
		Browser browser = new Browser();

		Thread.sleep(4000);
		browser.scrollToTable();
		Thread.sleep(4000);
	   System.out.println(WebtableRows.size());
	   for(int i=0;i<Webtablecols.size();i++)
	   {
		  String data= Webtablecols.get(i).getText();
		  System.out.print(data+" "+ "\t"+ " " );
		  System.out.println();
		  
		  
		 // String firname= driver.findElement(By.xpath("//table[@class='display dataTable']/tbody/tr/td[1]")).getText();
		  
		//  String salary = Webtablecols.get(i).getText();
		//  System.out.println(salary);
//		  if(name.equals("Caesar Vance"))
//		  {
//			  System.out.println("Name "+name+"  "+"Salary "+salary);
//		  }
	   }
		
					

		
      
	}

	@Test
	public boolean Verifyrecordexistsfor(String fname)
	{
		
		boolean flag = false;

		for(int i=0;i<Webtablecols.size();i++)
		   {
			String firstname= driver.findElement(By.xpath("//table[@class='display dataTable']/tbody/tr["+(i)+"]+/td[1]")).getText();
			
			if (firstname.equals(fname))
			{
			String salary= driver.findElement(By.xpath("//table[@class='display dataTable']/tbody/tr["+(i)+"]/td[6]")).getText();
		    
		    
		    driver.findElement(By.xpath("//button[contains(text(),'›')]")).click();
			}
		   }

		return flag;
	}


	//@Test
	public void VerifyRecordExists() {

		assertTrue(Verifyrecordexistsfor("ciera"));
	}
	@BeforeTest
	public void beforeTest() {
		Browser browser = new Browser();
		browser.launchBrowser("chrome");
		browser.openURL("https://datatables.net/examples/basic_init/alt_pagination.html");

	}

	@AfterTest
	public void afterTest() {
		//  browser.quit();
	}

}

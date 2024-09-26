package Demoqa;

import org.testng.annotations.Test;

import AutomationFramework.Browser;
import POM.HomePage;
import POM.WindowsHandlePage;

import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.script.Message;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class WindowsTest extends Browser{
	public WindowsTest wt;
	public HomePage homepage;
	public WindowsHandlePage windowhandlepage;

	// @Test
	public void VerifyNewTab() throws Throwable {
		homepage= new HomePage(driver);
		windowhandlepage = new WindowsHandlePage(driver);

		homepage.clickontab("Alerts, Frame & Windows");
		Thread.sleep(3000);
		windowhandlepage.clickBrowserWindow();
		Thread.sleep(3000);
		windowhandlepage.clickNewTab();
		Thread.sleep(3000);

		Set<String> windows=driver.getWindowHandles();
		windows.size();
		
		System.out.println(windows);
		
		Object[] wins=windows.toArray();
		
		String Window1=wins[0].toString();
		String Window2= wins[1].toString();
		
		driver.switchTo().window(Window2);

		// System.out.println(parent);
		Thread.sleep(3000);
		String Message= driver.findElement(By.id("sampleHeading")).getText();
		Thread.sleep(3000);
		Assert.assertTrue(Message.equals("This is a sample page"));
	}


	//@Test

	public void verifynewWindow() throws Throwable
	{
		homepage= new HomePage(driver);
		windowhandlepage = new WindowsHandlePage(driver);

		homepage.clickontab("Alerts, Frame & Windows");
		Thread.sleep(3000);
		windowhandlepage.clickBrowserWindow();
		Thread.sleep(3000);
		windowhandlepage.clickNewWindow();
		Thread.sleep(3000);

		Set<String> windows=driver.getWindowHandles();
		Object[] wins=windows.toArray();
		String Window1=wins[0].toString();
		String Window2= wins[1].toString();
		driver.switchTo().window(Window2);

		Thread.sleep(3000);
		String Message= driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(Message);
		Thread.sleep(3000);
		Assert.assertTrue(Message.equals("This is a sample page"));
		close();
	}
	
	@Test
	
	public void verifynewWindowMessage() throws Throwable
	{
		homepage= new HomePage(driver);
		windowhandlepage = new WindowsHandlePage(driver);

		homepage.clickontab("Alerts, Frame & Windows");
		Thread.sleep(3000);
		windowhandlepage.clickBrowserWindow();
		Thread.sleep(3000);
		windowhandlepage.clickNewWindowMessage();
		Thread.sleep(3000);

		Set<String> windows=driver.getWindowHandles();
		Object[] wins=windows.toArray();
		String Window1=wins[0].toString();
		String Window2= wins[1].toString();
		driver.switchTo().window(Window2);

		Thread.sleep(3000);
		//close();
		//String acttext= driver.findElement(By.xpath("//html/body")).getText();
		Assert.assertTrue(driver.getPageSource().contains("Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.")); 
		//System.out.println(acttext);
		Thread.sleep(3000);
       	//Assert.assertTrue(Message.equals("This is a sample page"));
		close();
		Thread.sleep(3000);
		driver.switchTo().window(Window1);
		Thread.sleep(3000);
		windowhandlepage.clickBrowserWindow();
		Thread.sleep(3000);
		
	}


	@BeforeTest
	public void beforeTest() throws Throwable, IOException {
		wt = new WindowsTest();
		String browser = getproperty("browser");
		wt.launchBrowser(browser);
		String URL = getproperty("AUT");
		driver = wt.openURL(URL);  
	}

	@AfterTest
	public void afterTest() {
		wt.quit();
	}

}

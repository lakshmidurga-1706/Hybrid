package Demoqa;

import org.testng.annotations.Test;

import AutomationFramework.Browser;
import POM.Frames;
import POM.HomePage;
import POM.MenuPage;

import org.testng.annotations.BeforeTest;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class WidgetsTest extends Browser{
	
	public WidgetsTest wedt;
	public HomePage homepage;
	public MenuPage menupage;
    
  @Test
  public void verifyMenuPage() throws Throwable {
	  homepage = new HomePage(driver);
	  menupage = new MenuPage(driver);
	  
	  homepage.clickontab("Widgets");
	  //menupage.clickWidgets();
	  menupage.clickMenu();
	  
	  Actions ac= new Actions(driver);
	  //WebElement Item1=driver.findElement(By.linkText("Main Item 1"));
	  //ac.moveToElement(Item1).click().perform();
	  Thread.sleep(5000);
	  Robot r = new Robot();
	  scrollToTop(driver.findElement(By.xpath("//a[normalize-space()='Main Item 2']")));
	  ac.moveToElement(driver.findElement(By.xpath("//a[normalize-space()='Main Item 2']")));
	  ac.build().perform();
	  Thread.sleep(5000);
	  ac.moveToElement(driver.findElement(By.xpath("//a[normalize-space()='SUB SUB LIST »']")));
	  ac.build().perform();
	  Thread.sleep(5000);
	  ac.moveToElement(driver.findElement(By.xpath("//a[normalize-space()='Sub Sub Item 1']")));
	  ac.build().perform();
	  
  }
  
  @BeforeTest
  public void beforeTest() throws Throwable  {
	  wedt = new WidgetsTest();
		String browser = getproperty("browser");
		wedt.launchBrowser(browser);
		String URL = getproperty("AUT");
		driver = wedt.openURL(URL);  
  }

  @AfterTest
  public void afterTest() {
	  //wedt.quit();
  }

}

package Demoqa;

import org.testng.annotations.Test;

import AutomationFramework.Browser;
import POM.Frames;
import POM.HomePage;

import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class FramesTest extends Browser {
	
	public FramesTest ft;
	public HomePage homepage;
	public Frames frames;
	
  @Test
  public void verifyFrames() throws Throwable {
	  homepage = new HomePage(driver);
	  frames = new Frames(driver);
	  
	  homepage.clickontab("Alerts, Frame & Windows");
	  frames.clickBrowserFrames();
	  frames.clickFrames();
	  Thread.sleep(3000);
	  
	  //List<WebElement> frames= driver.findElements(By.tagName("iframe"));
	  
	
	  WebElement frame1 = driver.findElement(By.id("frame1"));
	  driver.switchTo().frame(frame1);
	  
	  String ActText= driver.findElement(By.id("sampleHeading")).getText();
	  System.out.println(ActText);
	  Assert.assertTrue(ActText.equals("This is a sample page"));
	  driver.switchTo().defaultContent();
	  
	  }
  
  
  @BeforeTest
  public void beforeTest() throws Throwable {
	 
	  ft = new FramesTest();
		String browser = getproperty("browser");
		ft.launchBrowser(browser);
		String URL = getproperty("AUT");
		driver = ft.openURL(URL); 
  }

  @AfterTest
  public void afterTest() {
	  ft.quit();
  }

}

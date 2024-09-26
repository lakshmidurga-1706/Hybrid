package Demoqa;

import org.testng.annotations.Test;

import AutomationFramework.Browser;
import POM.CheckboxPage;
import POM.HomePage;
import POM.TablePage;
import POM.practiceformpage;

import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ElementsTest extends Browser {
	
	  public ElementsTest et;
	  public HomePage Homepage;
	  public CheckboxPage CheckboxPage;
	  public WebDriver _driver;
	
  @Test
  public void verifyClickcheckbox() throws Throwable {
	  
	  Homepage = new HomePage(_driver);
	 CheckboxPage = new CheckboxPage(_driver);
	 
	Homepage.clickontab("Elements");
	  
	 CheckboxPage.clickOnLinkCheckbox(); 
	 
	 CheckboxPage.clickCheckbox();
	 
	 Assert.assertTrue(CheckboxPage.verifychecboxsuccess(),"You have not selected");
  }
  
   @BeforeTest
  public void beforeTest() throws FileNotFoundException, IOException {
	  et = new ElementsTest();
	  String browser = getproperty("browser");
	  et.launchBrowser(browser);
	  String URL = getproperty("AUT");
	  _driver = et.openURL(URL);
  }

  @AfterTest
  public void afterTest() {
	  et.quit();
  }

}

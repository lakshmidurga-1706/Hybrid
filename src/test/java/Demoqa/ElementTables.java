package Demoqa;

import org.testng.annotations.Test;

import AutomationFramework.Browser;
import POM.CheckboxPage;
import POM.HomePage;
import POM.TablePage;

import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;


public class ElementTables extends Browser{
	

	  public ElementTables etab;
	  public HomePage homepage;
	  public CheckboxPage CheckboxPage;
	  public TablePage tablepage;
	  public WebDriver _driver;
	  
  //@Test
  public void VerifyNewRecordIsAddedToTheTable() throws Throwable {
	  homepage= new HomePage(_driver);
	  tablepage= new TablePage(_driver); 
	  
	  homepage.clickontab("Elements");
	  
	  tablepage.clickWebtable();
	  
	  tablepage.clickAddButton();
	  
	  tablepage.enterFirstname("Lakshmi");
	  
	  tablepage.enterLastname("Durga");
	  
	  tablepage.enterEmail("test@gamil.com");
	  
	  tablepage.enterAge("25");
	  
	  tablepage.enterSalary("50000");
	  
	  tablepage.enterDepartment("Computers");
	  
	  tablepage.clickSubmit();
	  
	  tablepage.verifyNewlyAddedRecIsVisibleInTable("Lakshmi", "Durga");
	  
	  
	  //tablepage.verifyEditTable("Testing");
  }
  
 // @Test
  public void VerifyNewRecordIsEditedInTheTable() throws Throwable {
	  homepage= new HomePage(_driver);
	  tablepage= new TablePage(_driver); 
	  
	  homepage.clickontab("Elements");
	  
	  tablepage.clickWebtable();
	  
	  tablepage.clickAddButton();
	  
	  tablepage.enterFirstname("Lakshmi");
	  
	  tablepage.enterLastname("Durga");
	  
	  tablepage.enterEmail("test@gamil.com");
	  
	  tablepage.enterAge("25");
	  
	  tablepage.enterSalary("50000");
	  
	  tablepage.enterDepartment("Computers");
	  
	  tablepage.clickSubmit();
	  
	  tablepage.verifyNewlyAddedRecIsVisibleInTable("Lakshmi", "Durga");
	  
	  tablepage.verifyEditTable("Lakshmi");
  }
  
  
  @Test
  public void VerifyDeleteRecordisSuccessful() throws Throwable {
	  
	  homepage= new HomePage(_driver);
	  tablepage= new TablePage(_driver); 
	  
	  homepage.clickontab("Elements");
	  
	  tablepage.clickWebtable();
	  
	  tablepage.clickAddButton();
	  
	  tablepage.enterFirstname("Lakshmi");
	  
	  tablepage.enterLastname("Durga");
	  
	  tablepage.enterEmail("test@gamil.com");
	  
	  tablepage.enterAge("25");
	  
	  tablepage.enterSalary("50000");
	  
	  tablepage.enterDepartment("Computers");
	  
	  tablepage.clickSubmit();
	  
	  tablepage.verifyDeleteRec("Lakshmi");
	  
  }
  
  
  @BeforeMethod
  public void beforeTest() throws FileNotFoundException, IOException {
	  etab = new ElementTables();
	  String browser = getproperty("browser");
	  etab.launchBrowser(browser);
	  String URL = getproperty("AUT");
	  _driver = etab.openURL(URL);
  }

  @AfterMethod
  public void afterTest() {
	  etab.quit();
  }

}

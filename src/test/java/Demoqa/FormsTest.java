package Demoqa;

import org.testng.annotations.Test;

import AutomationFramework.Browser;
import POM.HomePage;
import POM.practiceformpage;

import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class FormsTest extends Browser {
	
	  public FormsTest ft;
	  public HomePage homepage;
	  public practiceformpage practiceformpage;
	  public WebDriver _driver;
	  
  @Test
  public void VerifyUserRegistration() throws Throwable {
	  
	  homepage = new HomePage(_driver);

	  homepage.clickontab("Forms");
	  
	  practiceformpage = new practiceformpage(_driver);
	  
	  practiceformpage.clickPracticeForm();
	  practiceformpage.enterFirstName("sruthi");
	  practiceformpage.enterLastName("i");
	  practiceformpage.enterEmail("test@gmail.com");
	  practiceformpage.selectGender("female");
	  practiceformpage.enterMobileNumber("7894561230");
	  practiceformpage.selectDOB("2014", "August", "15");
	  practiceformpage.enterSubject("Science");
	  practiceformpage.selectHobbies("Reading");
	  practiceformpage.clickPicture("C:\\\\Users\\\\Admin\\\\Desktop\\\\image.jfif");
	  practiceformpage.enterAddress("Hyderabad");
	  practiceformpage.selectState();
	 practiceformpage.selectCity();
	  //practiceformpage.clickSubmit();
	  	  
//	  Assert.assertTrue(practiceformpage.verifyRegistrationSuccess(),
//			  "Registration is not successfull");
  }
  
  @BeforeTest
  public void beforeTest() throws FileNotFoundException, IOException {
	  
	  ft = new FormsTest();
	  String browser = getproperty("browser");
	  ft.launchBrowser(browser);
	  String URL = getproperty("AUT");
	  _driver = ft.openURL(URL);
  }

  @AfterTest
  public void afterTest() {
  ft.quit();
  }

}

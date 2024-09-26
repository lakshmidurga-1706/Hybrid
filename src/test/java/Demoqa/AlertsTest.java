package Demoqa;

import org.testng.annotations.Test;

import AutomationFramework.Browser;
import POM.Alertspage;
import POM.HomePage;
import POM.practiceformpage;
import dev.failsafe.Timeout;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertThrows;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class AlertsTest extends Browser{

	public AlertsTest at;
	public HomePage homepage;
	public Alertspage alertspage;


	//@Test
	public void verifyAlerts() throws Throwable {


		homepage.clickontab("Alerts, Frame & Windows");

		alertspage.clickAlerts();

		alertspage.clickFirstBtn();

		alertspage.clickSecondBtn();

		alertspage.clickConfirmBtn();

		alertspage.clickPromptBtn();

	}

	//@Test
	public void VerifyAlertForFirstButton() throws Throwable
	{
		homepage= new HomePage(driver);
		alertspage= new Alertspage(driver);

		homepage.clickontab("Alerts, Frame & Windows");

		alertspage.clickAlerts();

		alertspage.clickFirstBtn();

		String alerttext = GetAlertText();

		AcceptAlert();

		Assert.assertTrue(alerttext.equals("You clicked a button"));

	}

	//@Test
	public void VerifyAlertForSecondButton() throws Throwable
	{
		homepage= new HomePage(driver);
		alertspage= new Alertspage(driver);

		homepage.clickontab("Alerts, Frame & Windows");

		alertspage.clickAlerts();

		alertspage.clickSecondBtn();


		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(6));
		wait.until(ExpectedConditions.alertIsPresent());


		String alerttext = driver.switchTo().alert().getText();

		driver.switchTo().alert().accept();

		Assert.assertTrue(alerttext.equals("This alert appeared after 5 seconds"));

	}


	// @Test
	public void VerifyAlertForConfirmButton() throws Throwable
	{
		homepage= new HomePage(driver);
		alertspage= new Alertspage(driver);

		homepage.clickontab("Alerts, Frame & Windows");

		alertspage.clickAlerts();
		alertspage.clickConfirmBtn();
		Thread.sleep(3000);
		//String alertText= _driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		String exp = "You selected Ok";
		String act = driver.findElement(By.xpath("(//div[@class='col-md-6'])[3]/span[2]")).getText();
		Assert.assertEquals(act, exp, "Not matching");
	}
	
	
	@Test  
	public void VerifyAlertForPromptButton() throws Throwable
	{
		homepage= new HomePage(driver);
		alertspage= new Alertspage(driver);

		homepage.clickontab("Alerts, Frame & Windows");

		alertspage.clickAlerts();
		alertspage.clickPromptBtn();
		Thread.sleep(5000);
		driver.switchTo().alert().sendKeys("test");
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		String Exp = "You entered test";
		String Act = driver.findElement(By.xpath("(//div[@class='col-md-6'])[4]/span[2]")).getText();
		System.out.println(Act);
		Assert.assertEquals(Act, Exp, "Not matching");
	}

	@BeforeTest
	public void beforeTest() throws Throwable {
		at = new AlertsTest();
		String browser = getproperty("browser");
		at.launchBrowser(browser);
		String URL = getproperty("AUT");
		driver = at.openURL(URL);
	} 

	@AfterTest
	public void afterTest() {
		at.quit();
	}

}

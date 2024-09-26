package POM;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import AutomationFramework.Browser;

public class Alertspage extends Browser{
	
	public Alertspage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//li[contains(.,'Alerts')]")
	WebElement lnkalerts;
	
	@FindBy (id="alertButton")
	WebElement lnkfirstbutton;
	
	@FindBy (id="timerAlertButton")
	WebElement lnksecondbutton;
	
	@FindBy (id="confirmButton")
	WebElement lnkconfirmbutton;
	
	@FindBy (id="promtButton")
	WebElement lnkpromtbutton;
	
	public void clickAlerts() throws Throwable
	{
	this.lnkalerts.click();
	Thread.sleep(3000);
	}
	
	public void clickFirstBtn() throws Throwable
	{
		this.lnkfirstbutton.click();
		//Thread.sleep(3000);
		//driver.switchTo().alert().accept();
	}
	
	public void clickSecondBtn() throws Throwable
	{
		scrollToTop(this.lnksecondbutton);
		this.lnksecondbutton.click();
		//WebDriverWait wait= new WebDriverWait(driver, Duration(ofse)))
		//Thread.sleep(5000);
		//driver.switchTo().alert().accept();
	}
	
	public void clickConfirmBtn()
	{
		scrollToTop(lnkconfirmbutton);
	this.lnkconfirmbutton.click();
	//Alert confirmationAlert = driver.switchTo().alert();
	//String alertText = confirmationAlert.getText();
	//confirmationAlert.accept();
	}
	
	public void clickPromptBtn()
	{
		scrollToTop(lnkpromtbutton);
     this.lnkpromtbutton.click();
 //    Alert promptAlert  = driver.switchTo().alert();
  //   String alertText1 = promptAlert.getText();
  //   promptAlert.sendKeys("Test");
  //   promptAlert.accept();
     }
	
}

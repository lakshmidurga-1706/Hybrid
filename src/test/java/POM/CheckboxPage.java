package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationFramework.Browser;

public class CheckboxPage extends Browser {

	public CheckboxPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//span[text()='Check Box']")
	WebElement lnkcheckbox;
	
	@FindBy (xpath="//span[@class='rct-checkbox']")
	WebElement selectcheckbox;
	
	public void clickOnLinkCheckbox() throws Throwable
	{
		Thread.sleep(3000);
		this.lnkcheckbox.click();
	}
	
	public void clickCheckbox() throws Throwable
	{
		Thread.sleep(3000);
		this.selectcheckbox.click();
	}
	
	public boolean verifychecboxsuccess()
	{
		String Actual=driver.findElement(By.xpath("//div[@class='display-result mt-4']")).getText();
		String Expected="You have selected :";
		System.out.println(Actual);
        
		boolean flag=false;
		
		if(Actual.contains(Expected))
		{
			flag = true;
		}
		else
		{
			flag = false;
		}
		
		return flag;
	}
}

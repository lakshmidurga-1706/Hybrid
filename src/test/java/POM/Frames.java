package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import AutomationFramework.Browser;

public class Frames extends Browser{

	public Frames(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (xpath="//div[contains(text(),'Alerts, Frame & Windows')]")
	WebElement lnkframes;
	
	@FindBy (xpath="//span[normalize-space()='Frames']")
	WebElement clickframes;
	
	public void clickBrowserFrames()
	{
		this.lnkframes.click();
	}
	
	public void clickFrames()
	{
		this.clickframes.click();
	}
	
}

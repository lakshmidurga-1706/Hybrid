package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationFramework.Browser;

public class WindowsHandlePage extends Browser {
	public WindowsHandlePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//span[normalize-space()='Browser Windows']")
	WebElement lnkwindows;
	
	@FindBy (id ="tabButton")
	WebElement clicknewtab;
	
	@FindBy(id="")
	WebElement clicknewwindow;
	
	@FindBy (id="messageWindowButton")
	WebElement clicknewwindowmsg;
	
	public void clickBrowserWindow() throws Throwable
	{
		Thread.sleep(2000);
	this.lnkwindows.click();	
	}
	
	public void clickNewTab()
	{
		this.clicknewtab.click();
	}
	
	public void clickNewWindow() throws Throwable
	{
		scrollToTop(clicknewwindow);
		this.clicknewwindow.click();
	}
	
	public void clickNewWindowMessage()
	{
		scrollToTop(clicknewwindowmsg);
		this.clicknewwindowmsg.click();
	}
}

package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationFramework.Browser;

public class HomePage extends Browser{
	
	//public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy (xpath="//h5[normalize-space()='Elements']")
	WebElement tabelements;
	
	@FindBy (xpath="//h5[normalize-space()='Forms']")
	WebElement tabforms;
	
	@FindBy (xpath="(//div[@class='card mt-4 top-card'])[3]")
	WebElement tabalerts_windows;
	
    @FindBy (xpath="//h5[normalize-space()='Widgets']")
    WebElement tabwidgets;
    
    @FindBy (xpath="//h5[normalize-space()='Interactions']")
   WebElement tabinterations;
    
    @FindBy (xpath="//h5[normalize-space()='Book Store Application']")
    WebElement tabbookstore;
    
    
	public void clickontab(String tabname)
	{
		if(tabname.equals("Elements"))
		{
			scrollToTop(tabelements);
			tabelements.click();
		}
		else if(tabname.equals("Forms"))
		{
			scrollToTop(tabforms);
			tabforms.click();
		}
		else if(tabname.equals("Alerts, Frame & Windows"))
		{
			scrollToTop(tabalerts_windows);
			tabalerts_windows.click();
		}
		else if(tabname.equals("Widgets"))
		{
			scrollToTop(tabwidgets);
			tabwidgets.click();
		}
		else if(tabname.equals("Interactions"))
		{
			tabinterations.click();
		}
		else if(tabname.equals("Book Store Application"))
		{
			tabbookstore.click();
		}
	}
}

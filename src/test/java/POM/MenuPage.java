package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationFramework.Browser;

public class MenuPage extends Browser {
	public MenuPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath="//div[contains(text(),'Widgets')]")
	WebElement lnkwidgets;
	
	@FindBy (xpath="//span[normalize-space()='Menu']")
	WebElement clickmenu;
	
	public void clickWidgets()
	{
		scrollToTop(lnkwidgets);
		this.lnkwidgets.click();
	}
	
	public void clickMenu()
	{
		scrollToTop(clickmenu);
		this.clickmenu.click();
	}
	}
	
	
	
	


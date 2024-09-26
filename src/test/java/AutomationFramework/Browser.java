package AutomationFramework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser extends Basepage {
	
	public static WebDriver driver;
	
	public void launchBrowser(String browsertype)
	{
		if (browsertype.equals("chrome"))
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(browsertype.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browsertype.equals("edge"))
		{
			driver=new EdgeDriver();
		}
	}
	
	public WebDriver openURL(String URL)
	{
		 driver.get(URL);
		 return driver;
	}
	
	public void close()
	{
		driver.close();
	}
	
	public void quit()
	{
		driver.quit();
	}
	
	public void scrollToTop(WebElement elementtoscroll)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",elementtoscroll);
	}
	public void scrollToTable() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600);", "");
	}
	
	public String GetAlertText()
	{
		return driver.switchTo().alert().getText();
	}
	
	public void AcceptAlert()
	{
		driver.switchTo().alert().accept();
	}
	
	
	
	
	
	
	
	
	

}

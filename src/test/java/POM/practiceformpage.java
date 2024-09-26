package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AutomationFramework.Browser;

public class practiceformpage  extends Browser
{
	
	//public WebDriver driver;
	
	public practiceformpage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath="//span[normalize-space()='Practice Form']")
	WebElement lnkpracticeform;
	
	@FindBy (id="firstName")
	WebElement txtfirstname;
	
	@FindBy (id="lastName")
	WebElement txtlastname;
	
	@FindBy(id="userEmail")
	WebElement txtemail;
	
	@FindBy (xpath="//label[normalize-space()='Male']")
	WebElement radmale;
	
	@FindBy (xpath="//label[normalize-space()='Female']")
	WebElement radfemale;
	
	@FindBy (xpath="//label[normalize-space()='Other']")
	WebElement radother;
	
	@FindBy (id="userNumber")
    WebElement txtmobilenumber;	
	
	@FindBy (id="dateOfBirthInput")
	WebElement txtdob;
	
	@FindBy (xpath="//select[@class='react-datepicker__month-select']")
	WebElement ddmonth;
	
	@FindBy (xpath="//select[@class='react-datepicker__year-select']")
	WebElement ddyear;
	
	@FindBy (xpath="//div[text()='25']")
	WebElement lnkdate;
	
	@FindBy (id="subjectsContainer")
	WebElement txtSubjects;
	
	@FindBy (xpath="(//input[@type='checkbox'])[1]")
	WebElement radsports;
	
	@FindBy (xpath="//label[text()='Reading']")
	WebElement radreading;
	
	@FindBy (xpath="(//input[@type='checkbox'])[3]")
	WebElement radmusic;
	
	@FindBy (id="uploadPicture")
	WebElement lnkphoto;
	
	@FindBy (id="currentAddress")
	WebElement txtaddress;
	
	@FindBy (id="submit")
	WebElement lnksubmit;
	
	public void clickPracticeForm()
	{
		this.lnkpracticeform.click();
	}
	
	public void enterFirstName(String firstname)
	{
	   scrollToTop(txtfirstname);
       this.txtfirstname.sendKeys(firstname);
	}
	
	public void enterLastName(String lastname)
	{
		this.txtlastname.sendKeys(lastname);
	}
	
	public void enterEmail(String email)
	{
		this.txtemail.sendKeys(email);
	}
	
	public void selectGender(String gender)
	{
		if (gender.equals("male"))
		{  
			radmale.click();
		}
		else if(gender.equals("female"))
		{
			radfemale.click();
		}
		else if(gender.equals("other"))
		{
			radother.click();
		}
	}
	
	public void enterMobileNumber(String mobilenumber)
	{
		this.txtmobilenumber.sendKeys(mobilenumber);
	}
	
	public void clickDob()
	{
		scrollToTop(txtdob);
		this.txtdob.click();
	}
	
	public void selectMonth(String month)
	{
		Select mon = new Select(ddmonth);
		mon.selectByVisibleText(month);
		this.ddmonth.sendKeys(month);
	}
	
	public void selectYear(String year)
	{
		Select yea = new Select(ddyear);
		yea.selectByVisibleText(year);
		this.ddyear.sendKeys(year);
	}
	
	public void selectDay(String day)
	{
		driver.findElement(By.xpath("//div[text()='"+day+"']")).click();
		//this.lnkdate.sendKeys(day);
	}
	
	public void selectDOB(String year, String month, String day) throws InterruptedException
	{
		clickDob();
		Thread.sleep(2000);
		selectYear(year);
		selectMonth(month);
		selectDay(day);
	}
	
	
	public void enterSubject(String subname) throws InterruptedException
	{
	
		
		driver.findElement(By.id("subjectsInput")).sendKeys(subname);

		driver.findElement(By.xpath("//div[text()='Computer Science']")).click();
		
	}
	
	public void selectHobbies(String hobbies) throws Throwable
	{
		if(hobbies.equals("Sports"))
		{
			this.radsports.click();
		}
		else if(hobbies.equals("Reading"))
		{
		
			this.radreading.click();
		}
		else if(hobbies.equals("Music"))
		{
			this.radmusic.click();
		}
	}
	
	public void clickPicture(String picture)
	{
		this.lnkphoto.sendKeys(picture);
	}
	
	public void enterAddress(String address) throws Throwable
	{
		
		this.txtaddress.sendKeys(address,Keys.TAB);
	}
	
	public void selectState() 
	{
		
	}
	
	public void selectCity() throws InterruptedException
	{
		Actions ac=new Actions(driver);
		WebElement elementcity=driver.findElement(By.xpath("(//div[@class=' css-1wy0on6'])[2]"));
		ac.moveToElement(elementcity).click().perform();
	}
	
	public void clickSubmit()
	{
	this.lnksubmit.click();
	}
	
	public boolean verifyRegistrationSuccess()
	{
		boolean flag = false;
		
		String ActualText = driver.findElement(By.xpath("//div[@id='example-modal-sizes-title-lg']"))
		.getText();
		
		String ExpectedText = "Thanks for submitting the form";
		
		if(ActualText.equalsIgnoreCase(ExpectedText))
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
	


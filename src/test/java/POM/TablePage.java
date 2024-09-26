package POM;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AutomationFramework.Browser;

public class TablePage extends Browser {

	public TablePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath="//span[normalize-space()='Web Tables']")
	WebElement lnkwebtables;

	@FindBy (id="addNewRecordButton")
	WebElement clickadd;

	@FindBy (id="firstName")
	WebElement txtfirstname;

	@FindBy (id="lastName")
	WebElement txtlasstname;

	@FindBy (id="userEmail")
	WebElement txtemail;

	@FindBy (id="age")
	WebElement txtage;

	@FindBy (id="salary")
	WebElement txtsalary;

	@FindBy (id="department")
	WebElement txtdept;

	@FindBy(id="submit")
	WebElement lnksubmit;

	@FindBy(xpath="//div[@class='rt-table']/div/div")
	List<WebElement> webtable;	

	public void clickWebtable()
	{
		this.lnkwebtables.click();
	}

	public void clickAddButton()
	{
		this.clickadd.click();
	}

	public void enterFirstname(String firstname) throws Throwable
	{
		this.txtfirstname.sendKeys(firstname);
		Thread.sleep(2000);
	}

	public void enterLastname(String lastname) throws Throwable
	{
		this.txtlasstname.sendKeys(lastname);
		Thread.sleep(2000);
	}

	public void enterEmail(String email) throws Throwable
	{
		this.txtemail.sendKeys(email);
		Thread.sleep(2000);
	}

	public void enterAge(String age) throws Throwable
	{
		this.txtage.sendKeys(age);
		Thread.sleep(2000);
	}

	public void enterSalary(String salary) throws Throwable
	{
		this.txtsalary.sendKeys(salary);
		Thread.sleep(2000);
	}

	public void enterDepartment(String dept) throws Throwable 
	{
		this.txtdept.sendKeys(dept);
		Thread.sleep(2000);
	}

	public void clickSubmit() throws Throwable
	{
		this.lnksubmit.click();
		Thread.sleep(3000);
	}

	public void verifyNewlyAddedRecIsVisibleInTable(String fname, String lname)
	{
		List<WebElement> rows
		= driver.findElements(By.xpath("//div[@class='rt-tbody']/div"));

		int rowcount = rows.size();

		for(int i=0; i<rowcount; i++)
		{
			boolean flag = false;

			String firstname = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[1]/div[1]/div[1]")).getText();
			String lastname = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[1]/div[1]/div[2]")).getText();

			if (firstname.equals(fname) && lastname.equals(lname))
			{
				flag = true;
				Assert.assertTrue(flag);	
				//System.out.printf("Expected firstname is "+ fname);
				//System.out.printf("Actual firstname is "+firstname);
				break;
			}
		}
	}




	public void verifyEditTable(String fname) throws InterruptedException // Lakshmi
	{

		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='rt-tbody']/div"));
		int rowcount = rows.size();

		for(int i=0; i<rowcount; i++)
		{
			String firstname = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[" + (i+1) + "]/div[1]/div[1]")).getText();


			if (firstname.equals(fname))
			{
				WebElement btnEdit = driver.findElement(By.xpath("//span[@id='edit-record-"+ (i+1) +"']"));
				

				btnEdit.click();

				Thread.sleep(5000);
				txtfirstname.clear();
				txtfirstname.sendKeys("testing");

				Thread.sleep(5000);
				txtlasstname.clear();
				txtlasstname.sendKeys("testing");

				Thread.sleep(5000);

				lnksubmit.click();

				break;
			}
		}
	}



	public void verifyDeleteRec(String fname) throws Throwable
	{
		List<WebElement> rows
		= driver.findElements(By.xpath("//div[@class='rt-tbody']/div"));
		int rowcount = rows.size();


		for(int i=0; i<rowcount; i++)  
		{
			String firstname = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[" + (i+1) + "]/div[1]/div[1]")).getText();

			if (firstname.equals(fname))
			{
				Thread.sleep(5000);
				WebElement btnDelete = driver.findElement(By.xpath("//span[@id='delete-record-"+ (i+1) +"']"));
				btnDelete.click();
                break;
			}

		}
		for(int i=0; i<rowcount; i++)
		{
			boolean flag = true;

			String firstname = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[1]/div[1]/div[1]")).getText();
			//String lastname = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[1]/div[1]/div[1]")).getText();

			if (firstname.equals(fname))
			{
				flag = false;
				Assert.assertFalse(flag);	
				break;
			}
		}
	}
}

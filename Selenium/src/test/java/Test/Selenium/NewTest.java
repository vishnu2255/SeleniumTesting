package Test.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	PageObject obj;
  @BeforeTest  
  public void launchingApp() {
	
//	  WebDriver driver =new ChromeDriver();
	  obj= new PageObject();
	  WebDriver driver = obj.driver;
	  driver.get("C:\\QA Test (1).html");	  
	  driver.manage().window().maximize();	 
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
  }
  
  @Test(priority = 1)
  public void verifyingInputFields()
  {
	  
	  if(obj.fname.isDisplayed() && obj.lname.isDisplayed() && obj.phone.isDisplayed())
	  {
		  Assert.assertTrue(true);
	  }
	  else
	  {
		  Assert.assertTrue(false);
	  }
	  
  }
  
  @Test(priority =2)
  public void enterData()
  {
	  String fname = "",lname="",phone="";
	  String pattern = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
	  if(fname.length()<=20 && fname.matches("[a-zA-Z]+"))	  
	  {
		  obj.fname.sendKeys(fname);
	  }
	  if(lname.length()<=20 && lname.matches("[a-zA-Z]+"))	  
	  {
		  obj.lname.sendKeys(lname);
	  }
	  if(phone.matches(pattern))	  
	  {
		  obj.phone.sendKeys(phone);
	  }
	  
	  obj.submitBtn.click();
  }
  
}

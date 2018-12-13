package Test.Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Test123 {
  
  WebDriver driver;	
  
  @BeforeTest
  public void beforeTest() {
	  
	  driver =new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  
	  String url = "givenURL";
	  driver.get(url);
	  
  }
    
  @Test(priority=1)
  public void Test1() {
	
  //navigating to Home Page	  
  driver.findElement(By.name("Home")).click();
  
  WebElement email = driver.findElement(By.xpath("//div[@id='test-1-div']//form[@class='form-signin']//input[@type='email']"));
  
  WebElement password = driver.findElement(By.xpath("//div[@id='test-1-div']//form[@class='form-signin']//input[@type='password']"));
  
  WebElement loginBtn = driver.findElement(By.xpath("//div[@id='test-1-div']//form[@class='form-signin']//input[@type='submit']"));
  
  
  //Asserting whether all the elements are present or not
  Assert.assertTrue(email.isDisplayed() && password.isDisplayed() && loginBtn.isDisplayed());

  //input values
  email.sendKeys("test1@gmail.com");
  password.sendKeys("test@123");
  loginBtn.click();
  
  
  }

  @Test(priority=2)
  public void Test2()
  {
	 
  //navigating to Home Page	  
  driver.findElement(By.name("Home")).click();
  
  List<WebElement> eles = driver.findElements(By.xpath("//div[@id='test-2-div']//ul/li]"));

  Assert.assertEquals(eles.size(), 3);
  
  WebElement secList = driver.findElement(By.xpath("//div[@id='test-2-div']//ul/li[2]]"));
  
  String listText = secList.getText();
  
  Assert.assertEquals("List Item 2", listText);
  
  WebElement secListBadge = driver.findElement(By.xpath("//div[@id='test-2-div']//ul/li[2]/span]"));
  
  String badgeValue = secListBadge.getText();
  
  Assert.assertEquals("6", badgeValue);
  
  
  
  }
  
  @Test(priority=3)
  public void Test3() {

	  driver.findElement(By.name("Home")).click();	  	  	  	  	 
	  
	  Select sel = new Select(driver.findElement(By.xpath("//div[@id='test-3-div']/select")));
	  
	  WebElement option = sel.getFirstSelectedOption();
	  
	  Assert.assertEquals(option.getText(), "Option 1");
	  
	  sel.selectByVisibleText("Option 3");
	  	  
  }    
  
  @Test(priority=4)
  public void Test4() {

	  driver.findElement(By.name("Home")).click();
	  
	  WebElement frstButton = driver.findElement(By.xpath("//div[@id='test-4-div']/button[1]]"));
	  
	  WebElement secButton = driver.findElement(By.xpath("//div[@id='test-4-div']/button[2]]"));
	  
	  Assert.assertTrue(frstButton.isEnabled() && !secButton.isEnabled());
	  	  
	  
  }
  
  @Test(priority=5)
  public void Test5() {
  
    driver.findElement(By.name("Home")).click();
 
    final WebElement btn = driver.findElement(By.xpath("//div[@id='test-5-div']/button[1]]"));
    WebElement divText = driver.findElement(By.xpath("//div[@id='test-5-div']/div[1]]"));
		  
    WebDriverWait wait = new WebDriverWait(driver, 10);
    
    ExpectedCondition elementIsDisplayed = new ExpectedCondition<Boolean>() {
    	public Boolean apply(WebDriver arg0) {
    	  try {
    	     btn.isDisplayed();
    	     return true;
    	  }
    	  catch (NoSuchElementException e ) {
    	    return false;
    	  }
    	  catch (StaleElementReferenceException f) {
    	    return false;
    	  }
    	    }
    };
    
    wait.until(elementIsDisplayed);

    btn.click();
    
    Assert.assertEquals(divText.getText(), "You cliicked a button");
    
    Assert.assertTrue(!btn.isEnabled());
  
  }
  
  @Test(priority=6)
  public void Test6() {
  
	  driver.findElement(By.name("Home")).click();
	  String val = cellValue(2, 2);
	  
	  Assert.assertEquals(val, "Ventosanzap");	  
  }
  
  public String cellValue(int x,int y)
  {
	  
	  WebElement divText = driver.findElement(By.xpath("//div[@id='test-6-div']/table/tbody/tr["+x+"]/td["+y+"]]")); 
	 
	  return divText.getText();
  }
  
  @AfterTest
  public void afterTest() {
  
  driver.close();
  }

}
